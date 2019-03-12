import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by upupgogogo on 2019/2/26.下午2:10
 */
public class Solution4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0)
            return 0;

        double res = 0;

        int[] temp = new int[nums1.length + nums2.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < temp.length; i ++){
            if (l >= nums1.length)
                temp[i] = nums2[r++];
            else if (r >= nums2.length)
                temp[i] = nums1[l++];
            else if (nums1[l] < nums2[r])
                temp[i] = nums1[l++];
            else
                temp[i] = nums2[r++];
        }
        if (temp.length % 2 == 0)
            res = (double) (temp[temp.length / 2] + temp[temp.length / 2 - 1]) / 2;
        else
            res = temp[temp.length / 2];

        return res;
    }


    public static void main(String[] args) {

//        int[] nums = new int[10];
//        for (int i = 0; i < nums.length; i++)
//            nums[i] = (int) (Math.random()*100 + 1);
//        threeWaysSort(nums);
//
//        for (int i : nums)
//            System.out.println(i);
//        int[] nums = Arrays.copyOfRange(new int[]{1,2,3,4,5,6}, 2, 4 + 1);
//        for (int i : nums)
//            System.out.println(i);
//        System.out.println(nums.length);

        System.out.println(toSubArray(new int[]{1,2,34},new int[]{2,3,4,1,2,5,1,34,1,2,34}));
    }




    public static void mergeSort(int nums[]){
        merge(nums, 0, nums.length - 1);
    }

    private static void merge(int nums[], int l, int r){

        if (l >= r)
            return;
        int mid = (l + r) / 2;
        merge(nums, l, mid);
        merge(nums, mid + 1, r);
        sort(nums, l, mid, r);
    }

    private static void sort(int[] nums, int l, int  mid, int r) {
        if (l >= r)
            return;

        int[] temp = Arrays.copyOfRange(nums, l, r + 1);

        int lt = l - l;//数组temp区间[0,mid-l]的指针
        int gt = mid + 1 - l; //数组temp区间[mid+1-l,temp.length-1]的指针
        for (int i = l; i <= r; i ++){
            if (lt > mid - l)
                nums[i] = temp[gt++];
            else if (gt > r - l)
                nums[i] = temp[lt++];
            else if (temp[lt] > temp[gt])
                nums[i] = temp[gt++];
            else
                nums[i] = temp[lt++];
        }

    }


    public static void threeWaysSort(int nums[]){

        threeWays(nums, 0, nums.length - 1);
    }

    private static void threeWays(int[] nums, int l, int r) {
        if (l >= r)
            return;

        int temp = nums[l];
        int j = l;
        int jt = r;
        for (int i = l + 1; i <= jt; i ++){
            if (temp > nums[i]){
                j ++;
                swap(nums, i, j);
            }
            else if (temp < nums[i]){
                swap(nums, jt, i);
                jt --;
                i --;
            }
        }
        swap(nums, l, j);
        threeWays(nums, l, j - 1);
        threeWays(nums, jt + 1, r);
    }


    private static void swap(int[] nums, int m, int n){

        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }


    public static boolean toSubArray(int[] nums1, int[] nums2){
        if (nums1.length > nums2.length || (nums2.length == 0 && nums1.length == 0))
            return false;

        for (int i = 0; i < nums2.length; i ++)
            for (int j = 0; j < nums1.length; j++){
                 if ((i + j) >= nums2.length)
                     break;
                 if (nums2[i + j] != nums1[j])
                     break;
                 if (nums2[i + j] == nums1[j]){
                     if (j == nums1.length - 1)
                         return true;
                 }
            }
        return false;
    }


}
