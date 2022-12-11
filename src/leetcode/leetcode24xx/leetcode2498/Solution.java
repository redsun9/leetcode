package leetcode.leetcode24xx.leetcode2498;

public class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        if (n == 2) return stones[1] - stones[0];
        int ans = stones[2];
        for (int i = 3; i < n; i++) ans = Math.max(ans, stones[i] - stones[i - 2]);
        return ans;
    }
}
