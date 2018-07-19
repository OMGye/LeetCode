import java.util.ArrayList;
import java.util.List;

/**
 * Created by upupgogogo on 2018/6/5.下午3:30
 */
public class Solution129 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        List<List<Integer>> lists = pathSum(root);
        int sum = 0;
        for (List<Integer> list : lists){
             Integer num = 0;
             int n = 1;
             for (int i : list){
                 num = (int)Math.pow(10,list.size() - n)  + num;
                 n ++;
             }
             sum = num + sum ;
        }
        return sum;

    }

    public List<List<Integer>> pathSum(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        if (root.left == null && root.right == null) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                lists.add(list);
                return lists;
        }

        for (List<Integer> list : pathSum(root.left)) {
            List<Integer> re = new ArrayList<>();
            re.add(root.val);
            for (int i : list)
                re.add(i);
            lists.add(re);
        }
        for (List<Integer> list : pathSum(root.right)) {
            List<Integer> re = new ArrayList<>();
            re.add(root.val);
            for (int i : list)
                re.add(i);
            lists.add(re);
        }
        return lists;
    }
}
