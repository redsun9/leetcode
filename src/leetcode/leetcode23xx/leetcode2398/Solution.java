package leetcode.leetcode23xx.leetcode2398;

import java.util.ArrayDeque;

public class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        long sum = 0;
        int ans = 0;
        for (int l = 0, r = 0; l < n; l++) {
            while (r < n && ((queue.isEmpty() ? 0 : chargeTimes[queue.peekFirst()]) + sum * (r - l) <= budget)) {
                sum += runningCosts[r];
                while (!queue.isEmpty() && chargeTimes[queue.peekLast()] <= chargeTimes[r]) queue.pollLast();
                queue.addLast(r++);
            }
            if (r == n && (queue.isEmpty() ? 0 : chargeTimes[queue.peekFirst()]) + sum * (r - l) <= budget) {
                ans = Math.max(ans, r - l);
            } else ans = Math.max(ans, r - l - 1);
            if (r == n) return ans;
            sum -= runningCosts[l];
            if (!queue.isEmpty() && queue.peekFirst() == l) queue.pollFirst();
        }
        return ans;
    }
}
