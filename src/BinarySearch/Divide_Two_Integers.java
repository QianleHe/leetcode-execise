package BinarySearch;

/**
 * Created by qianle on 7/15/17.
 */
public class Divide_Two_Integers {
    public static void main(String[] args) {
        Divide_Two_Integers d = new Divide_Two_Integers();
        System.out.println(d.divide(Integer.MIN_VALUE, 1));
    }

    public int divide(int dividend, int divisor) {
        // 100 50 25 12
        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        //
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long absDividend = Math.abs((long)dividend);
        long absDivisor  = Math.abs((long)divisor);
        long res = 0;
        while (absDividend >= absDivisor) {
            int shift = 0;
            while (absDividend >= (absDivisor << shift)) {
                shift++;
            }
            absDividend -= (absDivisor << (shift - 1));
            res += (1 << (shift - 1));
        }
        return isNeg ? -1 * (int)res : (int)res;
    }
}
