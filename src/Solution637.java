import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by upupgogogo on 2018/6/3.下午2:55
 */
public class Solution637 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        average(root, 0, res , count);
        for (int i = 0; i < res.size(); i++)
            res.set(i,res.get(i) / count.get(i));
        return res;
    }

    public void average(TreeNode node, int i, List<Double> sum, List<Integer> count){
        if (node == null)
            return;
        if (i < sum.size()){
            sum.set(i,sum.get(i) + node.val);
            count.set(i,count.get(i) + 1);
        }
        else {
            sum.add(1.0 * node.val);
            count.add(1);
        }
        average(node.left, i + 1, sum, count);
        average(node.right, i + 1, sum, count);
    }

    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            Queue<TreeNode> temp = new LinkedList();
            double sum = 0;
            int count = 0;
            while (!queue.isEmpty()){
                TreeNode node = queue.remove();
                sum = sum + node.val;
                if (node.left != null)
                    temp.add(node.left);
                if (node.right != null)
                    temp.add(node.right);
                count++;
            }
            list.add(sum / count);
            queue = temp;

        }
        return list;
    }
}
