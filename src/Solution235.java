/**
 * Created by upupgogogo on 2018/6/6.下午6:44
 */
public class Solution235 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val >= p.val && root.val <= q.val)
            return root;
        if (root.val <= p.val && root.val >= q.val)
            return root;
        TreeNode res = null;
        if (root.val > p.val && root.val > q.val)
            res = lowestCommonAncestor(root.left,p,q);
        if (root.val < p.val && root.val < q.val)
            res = lowestCommonAncestor(root.right,p,q);
        return res;
    }

}
