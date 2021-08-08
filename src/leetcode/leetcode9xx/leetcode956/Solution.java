package leetcode.leetcode9xx.leetcode956;

import java.util.Arrays;

public class Solution {
    public int tallestBillboard(int[] rods) {
        int total = 0;
        for (int rod : rods) total += rod;
        int[] prev = new int[total << 1 | 1], curr = new int[total << 1 | 1], tmp;
        Arrays.fill(prev, -1);
        prev[total] = 0;
        Arrays.fill(curr, -1);
        int sum = 0;
        for (int rod : rods) {
            System.arraycopy(prev, total - sum, curr, total - sum, sum << 1 | 1);
            for (int i = total - sum; i <= total + sum; i++) {
                if (prev[i] == -1) continue;
                curr[i - rod] = Math.max(curr[i - rod], prev[i] + rod);
                curr[i + rod] = Math.max(curr[i + rod], prev[i] + rod);
            }
            sum += rod;
            tmp = curr;
            curr = prev;
            prev = tmp;
        }
        return prev[total] / 2;
    }
}
