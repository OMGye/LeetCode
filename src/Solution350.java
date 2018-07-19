import com.sun.source.tree.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by upupgogogo on 2018/7/7.下午7:31
 */
public class Solution350 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList();
        List list = new ArrayList();
        for (int num : nums1)
            list.add(num);
        for (int num : nums2){
            if (list.contains(num)){
                res.add(num);
                list.remove(new Integer(num));
            }
        }
        int[] arrayRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            arrayRes[i] = res.get(i);
        }
        return arrayRes;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap();
        for (int i : nums1){
            if (map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }
            else {
                map.put(i,1);
            }
        }
        List<Integer> res = new ArrayList();
        for (int num : nums2){
            if (map.containsKey(num)){
                res.add(num);
                map.put(num,map.get(num) - 1);
                if (map.get(num) == 0)
                    map.remove(num);
            }
        }
        int[] arrayRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            arrayRes[i] = res.get(i);
        }
        return arrayRes;

    }

    public static void main(String[] args) {
        Solution350.intersect(new int[]{1},new int[]{1});
    }
}
