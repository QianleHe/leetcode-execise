package BinarySearch;

/**
 * Created by qianle on 7/15/17.
 */
public class Pow {
    public static void main(String[] agrs) {
        Pow p = new Pow();
        System.out.println(p.myPow(2.1,-3));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        boolean isNeg = false;
        if (n < 0) {
            isNeg = true;
            n *= -1;
        }
        if (n % 2 == 1) {
            return isNeg ? 1/ (myPow(x, (n - 1) / 2) * myPow(x, (n - 1) / 2) * x) : myPow(x, (n - 1) / 2) * myPow(x, (n - 1) / 2) * x;
        }
        return isNeg ? 1 / (myPow(x, n / 2) * myPow(x, n / 2)) : myPow(x, n / 2) * myPow(x, n / 2);
    }
}
