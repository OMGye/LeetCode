import java.util.HashSet;
import java.util.Set;

/**
 * Created by upupgogogo on 2018/8/20.上午10:10
 */
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++){
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}
