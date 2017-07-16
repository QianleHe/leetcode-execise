package BinarySearch;

/**
 * Created by qianle on 7/15/17.
 */
public class Median_of_two_Sorted_Arrays {

    public static void main(String[] args) {
        Median_of_two_Sorted_Arrays u = new Median_of_two_Sorted_Arrays();
        int[] a = {1,2,3,4,5,6};
        int[] b = {2,3,4,5};
        double d = u.findMedianSortedArrays(a, b);
        System.out.println(d);
    }


    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) return 0;
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (getKth(A, 0, B, 0, len / 2) + getKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        } else {
            return getKth(A, 0, B, 0, len / 2 + 1);
        }
    }

    public int getKth(int[] A, int posA, int[] B, int posB, int k) {
        if (posA >= A.length) {
            return B[posB + k - 1];
        }
        if (posB >= B.length) {
            return A[posA + k - 1];
        }
        if (k == 1) return Math.min(A[posA], B[posB]);
        int A_key = (posA + k / 2 - 1) >= A.length ? Integer.MAX_VALUE : A[posA + k / 2 - 1];
        int B_key = (posB + k / 2 - 1) >= B.length ? Integer.MAX_VALUE : B[posB + k / 2 - 1];

        if (A_key < B_key) {
            return getKth(A, posA + k / 2, B, posB, k - k / 2);
        } else {
            return getKth(A, posA, B, posB + k / 2, k - k / 2);
        }

    }
}
