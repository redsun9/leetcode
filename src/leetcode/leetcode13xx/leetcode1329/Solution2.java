package leetcode.leetcode13xx.leetcode1329;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        if (m <= 1 || n <= 1) return mat;
        int[] arr = new int[m];
        int minD = -(n - 1), maxD = m - 1;
        for (int d = minD + 1; d < maxD; d++) {
            int minI = Math.max(d, 0), maxI = Math.min(d + n - 1, m - 1);
            for (int i = minI, j = i - d; i <= maxI; i++, j++) arr[i] = mat[i][j];
            Arrays.sort(arr, minI, maxI + 1);
            for (int i = minI, j = i - d; i <= maxI; i++, j++) mat[i][j] = arr[i];
        }
        return mat;
    }
}
