package BinarySearch;

/**
 * Created by qianle on 7/15/17.
 */
public class Search_A_Range {

    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) return new int[]{-1,-1};

        int[] res = new int[2];
        int start = 0;
        int end = A.length -1;
        // find the first number which is equal to target
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            res[0] = start;
        } else if (A[end] == target) {
            res[0] = end;
        } else {
            res[0] = -1;
        }

        start = 0;
        end = A.length - 1;
        //find the last number which is equal to target
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[end] == target) {
            res[1] = end;
        } else if (A[start] == target) {
            res[1] = start;
        } else {
            res[1] = -1;
        }

        return res;
    }

    public static void main(String[] args) {
        Search_A_Range s = new Search_A_Range();
        int[] arr = new int[]{1,2,3,4,4,4,4,4,4,6,7};

        int[] i = s.searchRange(arr, 4);
        System.out.println("[" + i[0] + ", " + i[1] + "]");
    }
}
