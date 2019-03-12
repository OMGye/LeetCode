import com.sun.org.apache.regexp.internal.RE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


/**
 * Created by upupgogogo on 2018/7/23.下午6:03
 */
public class Test {

    public String load(String url,String query) throws Exception
    {
        URL restURL = new URL(url);
        /*
         * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类 的子类HttpURLConnection
         */
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        //请求方式
        conn.setRequestMethod("HEAD");
        //设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
        conn.setDoOutput(true);
        //allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
        conn.setAllowUserInteraction(false);

        PrintStream ps = new PrintStream(conn.getOutputStream());
        ps.print(query);

        ps.close();

        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line,resultStr="";

        while(null != (line=bReader.readLine()))
        {
            resultStr +=line;
        }
        System.out.println("3412412---"+resultStr);
        bReader.close();

        return resultStr;

    }


    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(getHight(root.left) - getHight(root.right) <= 1 || getHight(root.left) - getHight(root.right) >= -1){
            if(isBalanced(root.left))
                return isBalanced(root.right);
        }
        return false;
    }

    public int getHight(TreeNode root){
        if(root == null)
            return 0;
        int left = 1 + getHight(root.left);
        int right = 1 + getHight(root.right);

        return left > right ? left : right;
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<List<Integer>> res = new LinkedList();

        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        if(root == null)
            return res;
        if(root.left == null && root.right == null)
            if(root.val == sum){
                res.add(Arrays.asList(root.val));
                return res;
            }
        for(List list : pathSum(root.left, sum - root.val))
            list.add(1, root.val);
        for(List list : pathSum(root.right, sum - root.val))
            list.add(1, root.val);
        return res;
    }


    public static void treePrintUseQueue(TreeNode node){
        if (node == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() > 0){
            TreeNode treeNode = queue.remove();
            System.out.println(treeNode.val);
            if (treeNode.left != null)
                queue.add(treeNode.left);
            if (treeNode.right != null)
                queue.add(treeNode.right);
        }

    }

    public static void treePrintUseStack(TreeNode node){
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            List<TreeNode> list = new ArrayList();
            while (!stack.isEmpty()){
                list.add(stack.pop());
            }
            for (int i = list.size() - 1; i >= 0; i--){
                if (list.get(i).left != null){
                    stack.push(list.get(i).left);
                }
                if (list.get(i).right != null){
                    stack.push(list.get(i).right);
                }
                System.out.print(list.get(i).val);
                if (i == 0)
                    System.out.println();
                else if (i != 0)
                    System.out.print("--->");

            }

        }

    }

    public static void root(TreeNode node){
        if (node == null)
            return;
        System.out.println(node.val);
        root(node.left);
        root(node.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode3.left = treeNode4;
        treeNode4.left = treeNode5;
        treeNode5.left = treeNode6;
        treeNode6.left = treeNode7;
        treeNode7.left = treeNode2;
        System.out.println(containsCricle(treeNode1));
        //treePrintUseStack(treeNode1);
      //  root(treeNode1);

    }

    public static int containsCricle(TreeNode node){
        return containsCricle(node,new HashSet());
    }

    private static int containsCricle(TreeNode node, Set set){

        if (node == null)
            return -1;

        if (set.contains(node))
            return node.val;
        set.add(node);
        return containsCricle(node.left, set);
    }
}