import java.util.*;

/**
 * Created by upupgogogo on 2018/8/18.下午4:36
 */
public class Solution15 {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3)
            return lists;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i ++){
            if (map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i]) + 1);
            else
                map.put(nums[i],1);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++){
            for (int j = i + 1; j < nums.length; j ++){
                if (map.containsKey(-(nums[i] + nums[j]))){
                   if (nums[i] < nums[j] && nums[j] < -(nums[i] + nums[j])){
                       lists.add(Arrays.asList(nums[i],nums[j],-(nums[i] + nums[j])));
                    }
                    else if (nums[i] == -(nums[i] + nums[j]) && map.get(nums[i]) >= 2 && nums[i] != nums[j]){
                       lists.add(Arrays.asList(nums[i],nums[j],-(nums[i] + nums[j])));
                   }
                   else if ((nums[j] == -(nums[i] + nums[j]) && map.get(nums[j]) >= 2 && nums[i] != nums[j])){
                        lists.add(Arrays.asList(nums[i],nums[j],-(nums[i] + nums[j])));
                    }
                    else if ((nums[j] == -(nums[i] + nums[j]) && map.get(nums[j]) >= 3 && nums[i] == nums[j])){
                       lists.add(Arrays.asList(nums[i],nums[j],-(nums[i] + nums[j])));
                   }
                }
                while (j + 1< nums.length && nums[j] == nums[j + 1]){
                    j ++;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]){
                i ++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        System.out.println(-(-1 + -1));
    }

}
