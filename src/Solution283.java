/**
 * Created by upupgogogo on 2018/7/22.下午3:10
 */
public class Solution283 {

    public int removeElement(int[] nums, int val) {

        int l = 0;

        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != val){
                swap(i,l,nums);
                l ++;
            }
            return l;
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
