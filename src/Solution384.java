/**
 * Created by upupgogogo on 2018/6/4.下午1:33
 */
public class Solution384 {

    public int[] nums;
    public int[] temp;

    public Solution384(int[] nums) {
        this.nums = nums;
        temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            temp[i] = nums[i];

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
       return temp;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int index = (int)(Math.random()*(nums.length -i));
            res[i] = nums[index];
            nums[index] = nums[nums.length - i -1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution384 solution384 = new Solution384(new int[]{1,2,3});
        int[] res = solution384.shuffle();
        for (int i : res)
            System.out.println(i);
    }
}
