package leetcode.leetcode19xx.leetcode1947;

public class Solution {
    private static int dfs(int i, int m, int key, int[][] dp, int[][] comp) {
        if (i == m) return 0;
        if (dp[i][key] == 0) {
            int tmp = 0;
            for (int j = 0; j < m; j++) {
                if ((key >> j & 1) != 0) tmp = Math.max(tmp, comp[i][j] + dfs(i + 1, m, key ^ 1 << j, dp, comp));
            }
            dp[i][key] = tmp + 1;
        }
        return dp[i][key] - 1;
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;

        int[] sMasks = new int[m];
        int[] mMasks = new int[m];

        for (int i = 0; i < m; i++) {
            int[] student = students[i];
            int studentMask = 0;
            for (int j = 0; j < n; j++) studentMask |= student[j] << j;
            sMasks[i] = studentMask;
        }

        for (int i = 0; i < m; i++) {
            int[] mentor = mentors[i];
            int mentorMask = 0;
            for (int j = 0; j < n; j++) mentorMask |= mentor[j] << j;
            mMasks[i] = mentorMask;
        }
        int[][] dp = new int[m][1 << m];
        int[][] comp = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                comp[i][j] = n - Integer.bitCount(sMasks[i] ^ mMasks[j]);
            }
        }
        return dfs(0, m, (1 << m) - 1, dp, comp);
    }
}
