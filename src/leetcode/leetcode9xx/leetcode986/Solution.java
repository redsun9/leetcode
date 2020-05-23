package leetcode.leetcode9xx.leetcode986;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        int m = a.length;
        int n = b.length;
        if (m == 0 || n == 0) return new int[0][2];
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>(Math.max(m, n) + 1);
        while (i < m && j < n) {
            while (i < m && j < n && (a[i][0] > b[j][1] || b[j][0] > a[i][1])) {
                while (i < m && a[i][1] < b[j][0]) i++;
                if (i == m) break;
                while (j < n && b[j][1] < a[i][0]) j++;
                if (j == n) break;
            }
            if (i == m || j == n) break;
            ans.add(new int[]{Math.max(a[i][0], b[j][0]), Math.min(a[i][1], b[j][1])});
            if (a[i][1] >= b[j][1]) j++;
            else i++;
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
