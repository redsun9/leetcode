package leetcode.leetcode19xx.leetcode1953;

public class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        int max = 0;
        for (int milestone : milestones) {
            if (milestone > max) {
                sum += max;
                max = milestone;
            } else sum += milestone;
        }
        return Math.min(sum + max, 2 * sum + 1);
    }
}
