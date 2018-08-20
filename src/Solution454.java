import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by upupgogogo on 2018/8/19.下午4:04
 */
public class Solution454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        if (A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0)
            return res;
        for (int i = 0; i < C.length; i ++)
            for (int j = 0; j < D.length; j++){
             if (map.containsKey(C[i] + D[j]))
                 map.put(C[i] + D[j], map.get(C[i] + D[j]));
             else
                 map.put(C[i] + D[j],1);
            }
        for (int i = 0; i < A.length; i ++)
            for (int j = 0; j < B.length; j ++){
                if (map.containsKey(0 - (A[i] + B[j]))){
                    res = res + map.get(0 - (A[i] + B[j]));
                }
            }
            return res;
    }

    public static void main(String[] args) {
        int[] test = new int[0];
        System.out.println(test[0]);
    }
}
