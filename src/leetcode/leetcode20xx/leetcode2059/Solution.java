package leetcode.leetcode20xx.leetcode2059;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int MAX_VAL = 1000;

    public int minimumOperations(int[] nums, int start, int goal) {
        if (start == goal) return 0;
        if (start > MAX_VAL || start < 0) return -1;

        int[] dp = new int[MAX_VAL + 1];
        dp[start] = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        int from, dist;
        while (!queue.isEmpty()) {
            from = queue.poll();
            dist = dp[from] + 1;

            for (int num : nums) {
                for (int next : new int[]{from + num, from - num, from ^ num}) {
                    if (next == goal) return dist - 1;
                    if (next >= 0 && next <= MAX_VAL && dp[next] == 0) {
                        dp[next] = dist;
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
