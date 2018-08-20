/**
 * Created by upupgogogo on 2018/8/6.上午1:21
 */
public class Solution76 {

    public String minWindow(String s, String t) {
        if(t.isEmpty() || s.isEmpty()) {
            return "";
        }
        int[] map = new int[128];
        for(int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int min = Integer.MAX_VALUE;
        String result = "";
        int counter = t.length();

        int slow = 0, fast = 0;
        while(fast < s.length()) {
            if(--map[s.charAt(fast)] >= 0) {
                counter--;
            }
            fast++;

            while(counter == 0) {
                if(fast - slow < min) {
                    min = fast - slow;
                    result = s.substring(slow, fast);
                }

                if(++map[s.charAt(slow)] > 0) {
                    counter++;
                }
                slow++;
            }
        }

        return result;
    }

}
