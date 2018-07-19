/**
 * Created by upupgogogo on 2018/7/19.下午5:29
 */
public class Solution387 {

    public int firstUniqChar(String s) {
        int nums[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            nums[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if(nums[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;

    }
}
