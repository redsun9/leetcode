package leetcode.leetcode37xx.leetcode3776;

public class Solution {
    public long minMoves(int[] balance) {
        int indexOfNegative = 0, n = balance.length;
        while (indexOfNegative < n && balance[indexOfNegative] >= 0) indexOfNegative++;
        if (indexOfNegative == n) return 0;

        long totalSum = 0;
        for (int num : balance) totalSum += num;
        if (totalSum < 0) return -1;

        long ans = 0;
        int left = -balance[indexOfNegative], i1 = (indexOfNegative + n - 1) % n, i2 = (indexOfNegative + 1) % n, diff = 1, took;
        while (left > 0) {
            took = Math.min(left, balance[i1] + balance[i2]);
            ans += (long) took * diff;
            left -= took;
            diff++;
            i1 = (i1 + n - 1) % n;
            i2 = (i2 + 1) % n;
        }
        return ans;
    }
}
