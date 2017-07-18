package Sort;

/**
 * Created by qianle on 7/17/17.
 */
public class Quick_Sort {

    public static void main(String[] args) {
        Quick_Sort q = new Quick_Sort();
        int[] arr = new int[]{2,1,3,4,44};
        q.quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int i = start, j = end, x = arr[i];
            while (i < j) {
                while (i < j && x <= arr[j]) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }

                while (i < j && x > arr[i]) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            quickSort(arr, start, i - 1);
            quickSort(arr, i + 1, end);
        }
    }
}
