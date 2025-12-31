package leetcode.leetcode37xx.leetcode3784;

public class Solution {
    public long minCost(String s, int[] cost) {
        long[] costForChar = new long[26];
        int n = s.length();
        for (int i = 0; i < n; i++) costForChar[s.charAt(i) - 'a'] += cost[i];
        long total = 0, max = 0;
        for (long c : costForChar) {
            total += c;
            max = Math.max(max, c);
        }
        return total - max;
    }
}
