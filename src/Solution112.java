/**
 * Created by upupgogogo on 2018/6/4.上午9:23
 */
public class Solution112 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if (root.left == null && root.right == null)
            return sum == root.val;
        boolean path = hasPathSum(root.left,sum - root.val);
        if (!path)
            path = hasPathSum(root.right,sum - root.val);
        return path;
    }
}
