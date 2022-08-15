package leetcode.leetcode23xx.leetcode2374;

public class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] sum = new long[n];
        for (int i = 0; i < n; i++) sum[edges[i]] += i;
        int ans = 0;
        long max = sum[0];
        for (int i = 1; i < n; i++) {
            if (sum[i] > max) {
                ans = i;
                max = sum[i];
            }
        }
        return ans;
    }
}
