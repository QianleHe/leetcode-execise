package BinarySearch;

/**
 * Created by qianle on 7/15/17.
 */
public class Search_Insert_Position {
    public static void main(String[] args) {
        Search_Insert_Position s = new Search_Insert_Position();
        int[] arr = {1,3,5,6};
        System.out.println(s.searchInsert(arr, 5));
        System.out.println(s.searchInsert(arr, 2));
        System.out.println(s.searchInsert(arr, 7));
        System.out.println(s.searchInsert(arr, 0));
    }

    public int searchInsert(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //找出最前面一个比target大的数
        if (arr[start] >= target) {
            return start;
        } else if(arr[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }


}
