package leetcode.leetcode20xx.leetcode2028;

public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int expected = mean * (n + m);
        for (int roll : rolls) expected -= roll;
        if (expected < n || expected > 6 * n) return new int[0];

        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = Math.min(expected - i, 6);
            expected -= ans[i];
        }
        return ans;
    }
}
