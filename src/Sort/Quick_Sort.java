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
        arr = new int[]{2,4,5,7,23,6};
        q.quickSort2(arr,0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
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


    // use the middle point as pivot
    private void quickSort2(int[] arr, int start, int end) {
        int i = start, j = end;
        int pivot = arr[start + (end - start) / 2];
        while (i < j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (start < j)
            quickSort2(arr, start, j);
        if (end > i)
            quickSort2(arr, i, end);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
