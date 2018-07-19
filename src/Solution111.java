/**
 * Created by upupgogogo on 2018/6/4.上午9:50
 */
public class Solution111 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.right == null && root.left != null)
            return minDepth(root.left) + 1;
        if (root.left == null && root.right != null)
            return minDepth(root.right) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;

    }
}
