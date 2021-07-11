package leetcode.leetcode17xx.leetcode1738;

import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        for (int[] row : matrix) {
            for (int i = 1; i < n; i++) row[i] ^= row[i - 1];
        }
        for (int i = 1; i < m; i++) {
            int[] prev = matrix[i - 1];
            int[] curr = matrix[i];
            for (int j = 0; j < n; j++) curr[j] ^= prev[j];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
        for (int[] row : matrix) {
            for (int a : row) {
                if (pq.size() < k) pq.offer(a);
                else if (pq.peek() < a) {
                    pq.offer(a);
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
