import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by upupgogogo on 2018/8/19.下午5:21
 */
public class Solution447 {

    public int numberOfBoomerangs(int[][] points) {
        if(points.length==0 || points[0].length==0) return 0;
        int ret = 0;
        for (int i = 0; i < points.length; i ++){
            Map<Integer, Set<int[]>> map = new HashMap<>();
            int q[] = points[i];
            for (int j = 0; j < points.length; j ++){
                if (i == j) continue;
                int p[] = points[j];
                if (!map.containsKey(getDis(p,q)))
                    map.put(getDis(p,q),new HashSet<int[]>());
                map.get(getDis(p,q)).add(p);
            }
            for (Integer key : map.keySet()){
                int size = map.get(key).size();
                if (size >= 2)
                    ret += size * (size - 1);
            }
        }
        return ret;
    }

    private int getDis(int p[], int q[]){
        int a = q[0] - p[0];
        int b = q[1] - p[1];
        return a*a + b*b;
    }
}
