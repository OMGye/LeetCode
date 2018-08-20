import com.sun.source.tree.BinaryTree;

import java.util.*;

/**
 * Created by upupgogogo on 2018/7/7.下午7:31
 */
public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums1.length; i ++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
            else
                map.put(nums1[i], 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i ++){
            if (map.containsKey(nums2[i])){
                if (map.get(nums2[i]) == 1){
                    list.add(nums2[i]);
                     map.remove(nums2[i]);
                }
                else{
                    list.add(nums2[i]);
                    map.put(nums2[i],map.get(nums2[i]) - 1);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i ++)
            res[i] = list.get(i);
        return res;
    }

}
