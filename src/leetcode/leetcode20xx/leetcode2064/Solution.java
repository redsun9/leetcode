package leetcode.leetcode20xx.leetcode2064;

public class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        long sum = 0;
        for (int quantity : quantities) {
            sum += quantity;
            max = Math.max(max, quantity);
        }

        int lo = (int) ((sum + n - 1) / n), hi = max;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(mid, n, quantities)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private static boolean check(int val, int n, int[] quantities) {
        for (int quantity : quantities) {
            n -= (quantity + val - 1) / val;
            if (n < 0) return false;
        }
        return true;
    }
}
