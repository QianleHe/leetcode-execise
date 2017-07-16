package BinarySearch;

/**
 * Created by qianle on 7/15/17.
 */
public class Find_Peak_Element {
    public int findPeak(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                start = mid;
            } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                end = mid;
            }
        }
        if (arr[start] > arr[start - 1] && arr[start] < arr[start + 1]) {
            return start;
        }
        return end;
    }

    public static void main(String[] args) {
        Find_Peak_Element f = new Find_Peak_Element();
        int[] arr = {1, 2, 1, 3, 4, 5, 7, 6};
        System.out.println(f.findPeak(arr));
    }
}
