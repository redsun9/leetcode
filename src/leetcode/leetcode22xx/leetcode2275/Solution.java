package leetcode.leetcode22xx.leetcode2275;

public class Solution {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        int[] count = new int[32];
        for (int candidate : candidates) for (int i = 0; i < 32; i++) if ((candidate & (1 << i)) != 0) count[i]++;

        int ans = 0;
        for (int c : count) ans = Math.max(ans, c);
        return ans;
    }
}
