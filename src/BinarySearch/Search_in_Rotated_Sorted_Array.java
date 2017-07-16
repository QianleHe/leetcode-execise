package BinarySearch;

/**
 * Created by qianle on 7/15/17.
 */

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 *(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 *You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 *You may assume no duplicate exists in the array.
 */
public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array s = new Search_in_Rotated_Sorted_Array();
        int[] arr = new int[]{5,6,7,8,1,2,3,4};
        System.out.println(s.search(arr, 7));
    }

    public int search(int[] arr, int target) {
        // if the array is null ,return -1
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[start] < arr[mid]) {
                if (arr[start] <= target && arr[mid] >= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (arr[end] >= target && arr[mid] <= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (arr[start] == target) {
            return start;
        } else if (arr[end] == target) {
            return end;
        }
        return -1;
    }
}
