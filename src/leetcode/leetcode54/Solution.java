package leetcode.leetcode54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return Collections.emptyList();
        int n = matrix[0].length;
        if (n == 0) return Collections.emptyList();
        int total = m * n;
        if (total == 1) return Collections.singletonList(matrix[0][0]);
        ArrayList<Integer> ans = new ArrayList<>(total);
        int i = 0, j = 0;
        ans.add(matrix[0][0]);
        int count = 1;

        int rb = n - 1;
        int lb = 0;
        int tb = 1;
        int bb = m - 1;


        while (true) {
            while (j < rb) {
                j++;
                ans.add(matrix[i][j]);
                if (++count == total) return ans;
            }
            rb--;
            while (i < bb) {
                i++;
                ans.add(matrix[i][j]);
                if (++count == total) return ans;
            }
            bb--;
            while (j > lb) {
                j--;
                ans.add(matrix[i][j]);
                if (++count == total) return ans;
            }
            lb++;
            while (i > tb) {
                i--;
                ans.add(matrix[i][j]);
                if (++count == total) return ans;
            }
            tb++;
        }
    }
}
