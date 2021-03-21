package leetcode.leetcode18xx.leetcode1802;

public class Solution {
    private static long count(int n, int index, int val) {
        return count(index + 1, val) + count(n - index, val) - val;
    }

    private static long count(int l, int h) {
        if (h >= l) return ((long) h * 2 - l + 1) * l / 2;
        else return (long) h * (h + 1) / 2 + l - h;
    }

    public int maxValue(int n, int index, int maxSum) {
        int lo = 1, hi = maxSum + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (count(n, index, mid) <= maxSum) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }
}
