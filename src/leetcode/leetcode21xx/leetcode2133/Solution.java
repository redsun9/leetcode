package leetcode.leetcode21xx.leetcode2133;

import java.util.BitSet;

// Space complexity - O(n^2), time complexity - O(n^2)

public class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        BitSet[] row = new BitSet[n], col = new BitSet[n];
        for (int i = 0; i < n; i++) {
            row[i] = new BitSet(n);
            col[i] = new BitSet(n);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i].set(matrix[i][j] - 1, true);
                col[j].set(matrix[i][j] - 1, true);
            }
        }

        for (int i = 0; i < n; i++) {
            if (row[i].cardinality() != n) return false;
            if (col[i].cardinality() != n) return false;
        }
        return true;
    }
}
