package Sort;

/**
 * Created by qianle on 7/18/17.
 */
public class Merge_Sort {

    public static void main(String[] args) {
        Merge_Sort m = new Merge_Sort();
        int[] arr = new int[]{2,5,2,43,88,33};
        m.mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public void merge(int[] arr, int lo, int middle, int hi) {
        int[] helper = arr.clone();
        int i = lo;
        int j = middle + 1;
        int k = lo;
        while (i <= middle && j <= hi) {
            if (helper[i] < helper[j]) {
                arr[k++] = helper[i++];
            } else {
                arr[k++] = helper[j++];
            }
        }
        while (i <= middle) {
            arr[k++] = helper[i++];
        }
    }

    public void mergeSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int middle = lo + (hi - lo) / 2;
            mergeSort(arr, lo, middle);
            mergeSort(arr, middle + 1, hi);
            merge(arr, lo, middle, hi);
        }
    }
}
