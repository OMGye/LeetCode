import java.util.Arrays;

/**
 * Created by upupgogogo on 2018/7/30.下午8:50
 */
public class Solution209 {

    public static int minSubArrayLen(int s, int[] nums) {

       int res = nums.length + 1;
       int l = 0, r = -1;
       int sum = 0;
       while (l < nums.length){
           if (sum < s & (r + 1) < nums.length)
               sum += nums[++r];
           else
               sum -= nums[--l];
           if (sum >= s)
               res = Math.min(res, r - l + 1);
       }
       if (res > nums.length)
           return 0;
        return res;
    }


    public static void main(String[] args) {
        minSubArrayLen(4,new int[]{1,4,4});
    }
}
