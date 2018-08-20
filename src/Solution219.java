import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by upupgogogo on 2018/8/7.上午1:41
 */
public class Solution219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set set = new HashSet();
        int l = 0;
        int lt = 0;
        while (l < nums.length){
            if (!set.contains(nums[lt])){
                set.add(nums[lt]);
            }
            else{
                return true;
            }
            lt ++;
            if (lt - l > k)
                set.remove(nums[l++]);
        }
        return false;
    }
}
