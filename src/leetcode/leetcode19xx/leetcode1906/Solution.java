package leetcode.leetcode19xx.leetcode1906;

public class Solution {
    public static final int MAX_NUM = 100;

    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] count = new int[n + 1][MAX_NUM + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(count[i], 0, count[i + 1], 0, MAX_NUM + 1);
            count[i + 1][nums[i]]++;
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int l = query[0], r = query[1];
            int prev = 0, mindDiff = MAX_NUM;
            for (int j = 1; j <= MAX_NUM; j++) {
                if (count[r + 1][j] - count[l][j] != 0) {
                    if (prev != 0) mindDiff = Math.min(mindDiff, j - prev);
                    prev = j;
                }
            }
            ans[i] = mindDiff == MAX_NUM ? -1 : mindDiff;
        }
        return ans;
    }
}
