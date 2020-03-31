package leetcode.leetcode2xx.leetcode278;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 0;
        int hi = n;
        while (hi - low > 1) {
            int mid = low + (hi - low) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                low = mid;
            }
        }
        return hi;
    }
}
