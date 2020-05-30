package leetcode.leetcode14xx.leetcode1462;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] pr = new boolean[n][n];
        for (int[] p : prerequisites) {
            pr[p[0]][p[1]] = true;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    pr[i][j] |= pr[i][k] && pr[k][j];
                }
            }
        }
        List<Boolean> ans = new ArrayList<>(n);
        for (int[] query : queries) {
            ans.add(pr[query[0]][query[1]]);
        }
        return ans;
    }
}
