package BinarySearch;

/**
 * Created by qianle on 7/15/17.
 */
public class First_Bad_Version {

    public int findFirstBadVersion(int n) {
        if (n == 0) return -1;
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBasVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isBasVersion(start)) {
            return start;
        } else {
            return end;
        }
        
    }

    private boolean isBasVersion(int mid) {
        return true;
    }

}
