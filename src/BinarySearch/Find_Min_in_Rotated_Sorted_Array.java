package BinarySearch;

import java.util.Stack;

/**
 * Created by qianle on 7/16/17.
 */
public class Find_Min_in_Rotated_Sorted_Array {

    public static void main(String[] args) {
        Find_Min_in_Rotated_Sorted_Array f = new Find_Min_in_Rotated_Sorted_Array();
        int[] arr = new int[]{1,2,3,4,8,9};
        System.out.println(f.findMin(arr));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        // find the first element which is smaller than last number
        int target = nums[nums.length - 1];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] <= target) {
            return nums[start];
        }
        return nums[end];
    }
}
