/**
 * Created by upupgogogo on 2018/7/26.下午3:09
 */
public class Solution88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int i = 0; i < m; i ++)
            temp[i] = nums1[i];

        int l = 0;
        int j = 0;
        for (int i = 0; i < m + n; i ++){
            if (l >= m) {
                nums1[i] = nums2[j];
                j ++;
            }
            else if(j >= n){
                nums1[i] = temp[l];
                l ++;
            }
            else if (temp[l] < nums2[j]){
                nums1[i] = temp[l];
                l ++;
            }
            else {
                nums1[i] = nums2[j];
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,0,0,0};
        merge(num1,3, new int[]{2,5,6},3);
        for (int i = 0; i < num1.length; i ++)
            System.out.println(num1[i]);
    }
}
