package leetcode.leetcode25xx.leetcode2528;

public class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long sum = k;
        for (int station : stations) sum += station;
        long lo = 0, hi = sum;
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            if (check(stations, r, k, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private static boolean check(int[] stations, int r, int k, long power) {
        int n = stations.length;
        long[] additional = new long[n];
        long sum = 0;
        for (int i = 0; i < r; i++) sum += stations[i];

        for (int i = 0, left = -r, right = r; i < n; i++, left++, right++) {
            if (right < n) sum += stations[right];
            if (sum < power) {
                additional[Math.min(right, n - 1)] += power - sum;
                k -= power - sum;
                if (k < 0) return false;
                sum = power;
            }
            if (left >= 0) {
                sum -= stations[left];
                sum -= additional[left];
            }
        }
        return true;
    }
}
