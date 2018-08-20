/**
 * Created by upupgogogo on 2018/7/31.下午4:16
 */
public class Solution3 {

    public static int lengthOfLongestSubstring(String s) {

        int res = 0;
        int l = 0, r = -1;
        int[] fre = new int[256];
        while (l < s.length()){
            if ((r + 1) < s.length() && fre[s.charAt(r + 1)] == 0)
                fre[s.charAt(++r)] ++;
            else
                fre[s.charAt(l++)] --;
            res = Math.max(res, r - l + 1);
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("11"));
    }
}
