/**
 * Created by upupgogogo on 2018/7/26.下午4:21
 */
public class Solution167 {

    public  int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];
        int n = 0;
        int m = numbers.length - 1;
        for (int i = 0; i < numbers.length; i ++){
            if (numbers[n] + numbers[m] == target){
                res[0] = n + 1;
                res[1] = m + 1;
                break;
            }
            else if (numbers[n] + numbers[m] < target){
                n ++;
            }
            else {
                m --;
            }
        }
        return res;
    }
}
