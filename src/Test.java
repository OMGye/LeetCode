import java.util.Map;
import java.util.TreeMap;

/**
 * Created by upupgogogo on 2018/7/23.下午6:03
 */
public class Test {

    public static void main(String[] args) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(5,1);
        treeMap.put(4,1);
        treeMap.put(6,1);
        treeMap.put(3,1);
        treeMap.put(2,1);
        for(Integer key : treeMap.keySet()) {

            Integer value = treeMap.get(key);

            System.out.println(key + " => " + value);
        }
    }
}
