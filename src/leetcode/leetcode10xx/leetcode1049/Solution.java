package leetcode.leetcode10xx.leetcode1049;

import java.util.Arrays;

public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int stone : stones) total += stone;
        boolean[] prev = new boolean[total << 1 | 1], curr = new boolean[total << 1 | 1], tmp;
        prev[total] = true;
        int prevSum = 0, sum = 0;
        for (int stone : stones) {
            System.arraycopy(prev, total - sum, curr, total - sum + stone, sum << 1 | 1);
            if (prevSum > sum - stone) Arrays.fill(curr, total - prevSum, total - sum + stone, false);
            for (int i = -sum, i1 = total - sum, i2 = i1 - stone; i <= sum; i++, i1++, i2++) curr[i2] |= prev[i1];
            prevSum = sum;
            sum += stone;
            tmp = curr;
            curr = prev;
            prev = tmp;
        }
        int ans = 0, i1 = total, i2 = total;
        while (!(prev[i1--] || prev[i2++])) ans++;
        return ans;
    }
}
