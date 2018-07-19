/**
 * Created by upupgogogo on 2018/6/5.下午5:14
 */
public class Solution437 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return findPath(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    public int findPath(TreeNode node, int sum){
        if (node == null)
            return 0;
        int res = 0;
        if (node.val == sum)
            res = res + 1;
        res = res + findPath(node.left, sum - node.val);
        res = res + findPath(node.right, sum - node.val);
        return res;
    }
}
