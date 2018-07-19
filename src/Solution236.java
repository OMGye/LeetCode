/**
 * Created by upupgogogo on 2018/6/7.下午12:25
 */
public class Solution236 {

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
        if (contains(root.left,p.val) && contains(root.left,q.val))
            return lowestCommonAncestor(root.left,p,q);
        if (contains(root.right,p.val) && contains(root.right,q.val))
            return lowestCommonAncestor(root.right,p,q);
        return root;

    }

    public boolean contains(TreeNode root, int value){
        if (root == null)
            return false;
        if (root.val == value)
            return true;
         boolean res = contains(root.left, value);
         if (!res)
             res = contains(root.right, value);
         return res;

    }
}
