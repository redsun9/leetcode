package leetcode.leetcode22xx.leetcode2285;

import java.util.Arrays;

public class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long ans = 0;
        long[] degree = new long[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        for (int i = 0; i < n; i++) ans += degree[i] * (i + 1);
        return ans;
    }
}
