package leetcode.leetcode19xx.leetcode1954;

public class Solution {
    public long minimumPerimeter(long neededApples) {
        int lo = 1, hi = 100_000;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long val = 2L * mid * (mid + 1) * (2L * mid + 1);
            if (neededApples > val) lo = mid + 1;
            else hi = mid;
        }
        return 8L * lo;
    }
}
