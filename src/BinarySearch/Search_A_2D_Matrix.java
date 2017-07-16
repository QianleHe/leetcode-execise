package BinarySearch;

/**
 * Created by qianle on 7/15/17.
 */
public class Search_A_2D_Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8}};
        Search_A_2D_Matrix s = new Search_A_2D_Matrix();
        System.out.println(s.searchMatrix(matrix, 9));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;
        int len = row * col;

        int start = 0;
        int end = len - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / col][mid % col] > target) {
                end = mid;
            } else if (matrix[mid / col][mid % col] < target) {
                start = mid;
            } else {
                return true;
            }
        }
        if (matrix[start / col][start % col] == target) {
            return true;
        } else if (matrix[end / col][end % col] == target) {
            return  true;
        }
        return false;
    }
}
