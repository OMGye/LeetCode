import java.util.*;

/**
 * Created by upupgogogo on 2018/8/18.下午1:43
 */
public class Solution1 {

    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (target == nums[i] * 2) {
                    res[0] = map.get(nums[i]);
                    res[1] = i;
                    return res;
                }
            }
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i ++){
            if (map.containsKey(target - nums[i]) && target - nums[i] != nums[i]){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        twoSum2(new int[]{2,7,11,15},9);
    }
}
