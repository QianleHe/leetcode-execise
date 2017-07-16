package BinarySearch;

/**
 * Created by qianle on 7/16/17.
 */

// what if duplicates allow in array
public class Search_in_Rotated_Sorted_Array_2 {

    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array_2 s = new Search_in_Rotated_Sorted_Array_2();
        int[] arr = new int[]{1,1,1,1,0,1,1,1};
        System.out.println(s.search(arr, 11));
    }

    public boolean search(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}
