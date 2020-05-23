package leetcode.leetcode13xx.leetcode1337;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Comparator<int[]> comparator = Comparator.comparingInt((int[] a) -> -a[0]).thenComparingInt(a -> -a[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(k + 1, comparator);

        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int count = 0;
            int[] row = mat[i];
            while (count < n && row[count] == 1) count++;
            pq.offer(new int[]{count, i});
            if (pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }
}
