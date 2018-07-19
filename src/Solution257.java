import java.util.ArrayList;
import java.util.List;

/**
 * Created by upupgogogo on 2018/6/4.下午2:16
 */
public class Solution257 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null)
            return list;
        if (root.left == null && root.right == null){
            list.add(Integer.toString(root.val));
            return list;
        }
        for (String s : binaryTreePaths(root.left)){
            list.add(Integer.toString(root.val) + "->" + s);
        }
        for (String s : binaryTreePaths(root.right)){
            list.add(Integer.toString(root.val) + "->" + s);
        }
        return list;

    }



}
