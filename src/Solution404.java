/**
 * Created by upupgogogo on 2018/6/4.上午10:20
 */
public class Solution404 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null && root.right == null)
            return root.left.val + sumOfLeftLeaves(root.left) ;
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }


}
