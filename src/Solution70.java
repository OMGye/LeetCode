
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by upupgogogo on 2018/7/16.下午3:22
 */
public class Solution70 {

    Map<Integer,Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        map.put(1,1);
        map.put(0,1);
        for (int i = 2; i <= n; i ++)
            map.put(i,map.get(i - 1) + map.get(i - 2));

        return map.get(n);

    }
}
