package leetcode.leetcode29xx.leetcode2917;

public class Solution {
    public int findKOr(int[] nums, int k) {
        int[] cnt = new int[32];
        for (int num : nums) for (int i = 0; i < 31; i++) cnt[i] += (num >> i) & 1;
        int ans = 0;
        for (int i = 0; i < 31; i++) if (cnt[i] >= k) ans |= 1 << i;
        return ans;
    }
}
