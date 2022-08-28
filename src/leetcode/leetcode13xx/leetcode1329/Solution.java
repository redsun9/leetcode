package leetcode.leetcode13xx.leetcode1329;

import java.util.PriorityQueue;

@SuppressWarnings({"ConstantConditions", "DuplicatedCode", "unchecked"})
public class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<Integer>[] pq = new PriorityQueue[m + n - 1];
        for (int i = 0; i < m + n - 1; i++) {
            pq[i] = new PriorityQueue<>();
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                pq[i - j + n - 1].add(mat[i][j]);
            }
        }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                mat[i][j] = pq[i - j + n - 1].poll();
        return mat;
    }
}
