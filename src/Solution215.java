/**
 * Created by upupgogogo on 2018/7/26.下午3:44
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {

        return threeWaysQuickSort(nums, 0, nums.length -1, k);
    }

    private int threeWaysQuickSort(int[] nums, int l, int r, int k){

        if (l == r)
            return nums[l];
        int v = nums[l];

        int lt = l;
        int gt = r;

        for (int i = lt; i <= gt; i ++){
            if (v > nums[i]){
                swap(nums, i, lt);
                lt ++;
            }
            else if (v < nums[i]){
                swap(nums, i, gt);
                gt --;
                i --;
            }
        }
        if (nums.length - gt <= k && nums.length - lt >= k){
            return nums[lt];
        }
        if (nums.length - gt > k)
            return threeWaysQuickSort(nums,gt + 1, r, k);
        else
            return threeWaysQuickSort(nums,l, lt - 1, k);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
