import java.util.ArrayList;
import java.util.List;

/**
 * Created by upupgogogo on 2018/7/16.下午4:24
 */
public class Solution120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];

        for(int r = triangle.size() - 1; r >= 0; r--) {
            for(int c = 0; c <= r; c++) {
                int min = Math.min(dp[c], dp[c+1]);
                dp[c] = triangle.get(r).get(c) + min;
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(-1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(0);

        List<Integer> list3 = new ArrayList<>();
        list3.add(-1);
        list3.add(1);
        list3.add(0);

        triangle.add(list);
        triangle.add(list2);
        triangle.add(list3);

        System.out.println(Solution120.minimumTotal(triangle));
    }
}
