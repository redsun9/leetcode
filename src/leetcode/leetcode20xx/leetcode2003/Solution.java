package leetcode.leetcode20xx.leetcode2003;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) pq.offer(new int[]{nums[i], i});
        }

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int val = node[0];
            if (ans[0] < val) break;
            int u = node[1];
            while (u != -1) {
                if (ans[u] == val) ans[u]++;
                u = parents[u];
            }
        }
        return ans;
    }
}
