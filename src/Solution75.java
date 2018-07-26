import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by upupgogogo on 2018/7/22.下午11:23
 */
public class Solution75 {

    public static void sortColors(int[] nums) {
        int lt = 0;
        int gt = nums.length -1;
        for (int i = lt; i < gt; i ++){
            if (nums[i] < 1){
                swap(nums, i, lt);
                lt ++;
            }
            else if (nums[i] > 1){
                swap(nums, i, gt);
                gt --;
                i --;
            }
        }
    }

    private void quick(int[] nums, int l, int r){
        if (l >= r)
            return;
        int index = sort(nums, l, r);
        quick(nums, l, index - 1);
        quick(nums, index + 1, r);
    }

    private int sort(int[] nums, int l, int r){

        int j = l;
        for (int i = l + 1; i <= r; i ++)
            if (nums[l] > nums[i]){
                swap(nums, i, j);
                j ++;
            }
        swap(nums,l,j);
        return j;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }
}
