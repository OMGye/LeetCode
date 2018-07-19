import java.util.ArrayList;
import java.util.List;

/**
 * Created by upupgogogo on 2018/6/5.下午2:29
 */
public class Solution113 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                lists.add(list);
            }
            return lists;
        }

        for (List<Integer> list : pathSum(root.left, sum - root.val)) {
            List<Integer> re = new ArrayList<>();
            re.add(root.val);
            for (int i : list)
                re.add(i);
            lists.add(re);
        }
        for (List<Integer> list : pathSum(root.right, sum - root.val)) {
            List<Integer> re = new ArrayList<>();
            re.add(root.val);
            for (int i : list)
                re.add(i);
            lists.add(re);
        }
        return lists;

    }
}
