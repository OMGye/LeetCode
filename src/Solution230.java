import java.util.ArrayList;
import java.util.List;

/**
 * Created by upupgogogo on 2018/6/7.上午11:50
 */
public class Solution230 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        List list = new ArrayList();
        getAll(root,list);
        return ((TreeNode)list.get(k - 1)).val;
    }

    public void getAll(TreeNode root, List list){
        if(root == null)
            return ;
        getAll(root.left, list);
        getAll(root.right,list);
        list.add(root);
    }
}
