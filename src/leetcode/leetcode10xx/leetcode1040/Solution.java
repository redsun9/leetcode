package leetcode.leetcode10xx.leetcode1040;

import java.util.Arrays;

public class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int max = Math.max(stones[n - 2] - stones[0], stones[n - 1] - stones[1]) - n + 2;
        int l = 0, min = n - 1;
        for (int r = 0; r < n; r++) {
            while (stones[r] - stones[l] >= n) l++;
            if (r - l == n - 2 && stones[r] - stones[l] == n - 2) min = Math.min(min, 2);
            else min = Math.min(min, n - r + l - 1);
        }
        return new int[]{min, max};
    }
}
