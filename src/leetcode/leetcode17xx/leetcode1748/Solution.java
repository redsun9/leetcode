package leetcode.leetcode17xx.leetcode1748;

public class Solution {
    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) cnt[num]++;
        int ans = 0;
        for (int i = 1; i <= 100; i++) if (cnt[i] == 1) ans += i;
        return ans;
    }
}
