package BinarySearch;

/**
 * Created by qianle on 7/15/17.
 */
public class RotateString {
    public static void main(String[] args) {
        RotateString r = new RotateString();
        char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        r.rotateString(str, 2);
        for (char c : str) {
            System.out.print(c);
        }
    }

    public void rotateString(char[] str, int offset) {
        // abcdefg if offset = 2 4 l = 7
        // fgabcde
        // 三步翻转法
        if (str == null || str.length == 0) return;
        offset = offset % str.length;
        rotate(str, 0, str.length - offset - 1);
        rotate(str, str.length - offset, str.length - 1);
        rotate(str, 0, str.length - 1);
    }

    public void rotate(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }


}
