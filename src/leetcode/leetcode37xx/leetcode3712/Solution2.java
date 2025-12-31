package leetcode.leetcode37xx.leetcode3712;

public class Solution2 {
    public int sumDivisibleByK(int[] nums, int k) {
        int maxPossible = 100;
        int[] cnt = new int[maxPossible + 1];
        for (int num : nums) cnt[num]++;
        int ans = 0;
        for (int i = 1; i <= maxPossible; i++) {
            if (cnt[i] % k == 0) ans += i * cnt[i];
        }
        return ans;
    }
}
