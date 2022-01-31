package leetcode.leetcode21xx.leetcode2133;

import java.util.BitSet;

// Space complexity - O(n), time complexity - O(n^2)

public class Solution2 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int[] ints : matrix) {
            BitSet set = new BitSet(n);
            for (int j = 0; j < n; j++) set.set(ints[j] - 1, true);
            if (set.cardinality() != n) return false;
        }

        for (int j = 0; j < n; j++) {
            BitSet set = new BitSet(n);
            for (int[] ints : matrix) set.set(ints[j] - 1, true);
            if (set.cardinality() != n) return false;
        }
        return true;
    }
}
