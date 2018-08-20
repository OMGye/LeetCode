import java.util.ArrayList;
import java.util.List;

/**
 * Created by upupgogogo on 2018/8/3.下午12:54
 */
public class Solution438 {

    public static List<Integer> findAnagrams(String s, String p) {

        int fre[] = new int[256];
        int hash[] = new int[256];
        int l = 0; int r = p.length() - 1;
        if (s.length() >= p.length()) {
            for (int i = 0; i <= r; i++){
                fre[s.charAt(i)]++;
                hash[s.charAt(i)]++;
            }
        }
        else
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int index = 0;
        while (l < (s.length() - p.length() + 1)){
            for (int i = 0; i < p.length(); i ++)
                if (fre[p.charAt(i)] != hash[p.charAt(i)]) {
                    index++;
                }
                else {

                }
            if (index == 0){
                list.add(l);
            }
            fre[s.charAt(l++)] --;
            if (r + 1 < s.length())
                fre[s.charAt(++r)] ++;
            index = 0;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd"
                ,"abc"));
    }
}
