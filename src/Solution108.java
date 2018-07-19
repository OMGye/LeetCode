/**
 * Created by upupgogogo on 2018/6/6.下午7:17
 */
public class Solution108 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public  TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        TreeNode node = new TreeNode(nums[nums.length / 2]);
        int[] leftNums = new int[nums.length / 2];
        for (int i = 0; i < leftNums.length; i++)
            leftNums[i] = nums[i];
        node.left = sortedArrayToBST(leftNums);
        int rightSize = nums.length - leftNums.length - 1;
        int[] rightNums = new int[rightSize];
        int n = 0;
        for (int i = nums.length / 2 + 1; i < nums.length; i++) {
            rightNums[n] = nums[i];
            n++;
        }
        node.right = sortedArrayToBST(rightNums);
        return node;

    }

    public static void main(String[] args) {
        Solution108 solution108 = new Solution108();
        int[] re = {1,2,3,4,5,6,7,8,9};
        TreeNode node = solution108.sortedArrayToBST(re);
        System.out.println(node);
    }
}
