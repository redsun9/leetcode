package leetcode.leetcode19xx.leetcode1992;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        List<int[]> ans = new ArrayList<>();
        for (int i2 = 0; i2 < m; i2++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (land[i2][j2] == 1 && (i2 == m - 1 || land[i2 + 1][j2] == 0) && (j2 == n - 1 || land[i2][j2 + 1] == 0)) {
                    int i1 = i2, j1 = j2;
                    while (i1 > 0 && land[i1 - 1][j2] == 1) i1--;
                    while (j1 > 0 && land[i2][j1 - 1] == 1) j1--;
                    ans.add(new int[]{i1, j1, i2, j2});
                }
            }
        }

        int[][] arr = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) arr[i] = ans.get(i);
        return arr;

    }
}
