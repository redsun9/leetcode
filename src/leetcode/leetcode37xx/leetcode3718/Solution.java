package leetcode.leetcode37xx.leetcode3718;

public class Solution {
    public int missingMultiple(int[] nums, int k) {
        int maxPossible = 100;
        boolean[] set = new boolean[maxPossible + 1];
        for (int num : nums) set[num] = true;
        int ans = k;
        while (ans <= maxPossible && set[ans]) ans += k;
        return ans;
    }
}
