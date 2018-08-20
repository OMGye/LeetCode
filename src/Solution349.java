import java.util.*;

/**
 * Created by upupgogogo on 2018/8/18.下午12:03
 */
public class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums1.length; i ++)
            set.add(nums1[i]);

        List<Integer> res = new ArrayList();
        for (int i = 0; i < nums2.length; i ++)
            if (set.contains(nums2[i])){
                res.add(nums2[i]);
                set.remove(nums2[i]);
            }
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i ++)
            r[i] = res.get(i);
        return r;
    }
}
