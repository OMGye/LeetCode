import java.util.ArrayList;
import java.util.List;

/**
 * Created by upupgogogo on 2018/6/9.下午2:07
 */
public class Solution17 {

    public String str[] = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    List list = new ArrayList();

    public void findCombination(String digits, int index, String s){
        if (index == digits.length()){
            list.add(s);
            return;
        }
        String letters = str[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++)
            findCombination(digits, index + 1, s + letters.charAt(i));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")){
            return list;
        }
        findCombination(digits, 0, "");
        return list;
    }


    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        solution17.letterCombinations("234");
        System.out.println(solution17.list);
    }


}
