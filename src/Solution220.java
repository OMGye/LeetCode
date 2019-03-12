import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by upupgogogo on 2018/8/20.下午12:14
 */
public class Solution220 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        int l = 0;
        int lt = 0;
        TreeSet<Long> set = new TreeSet<>();
        while (l < nums.length && lt < nums.length){
            if (set.ceiling((long)nums[lt] - (long)t) != null  && set.ceiling((long)nums[lt] - (long)t) <= (long) nums[lt] + (long) t){
                return true;
            }
            set.add((long) nums[lt ++]);
            if (lt - l > k){
                set.remove((long) nums[l++]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},2,3);
    }
}
