package leetcode.leetcode4xx.leetcode477;

public class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (num & (1 << i)) >> i;
            }
        }
        int ans = 0;
        int n = nums.length;
        for (int bit : bits) {
            ans += bit * (n - bit);
        }
        return ans;

    }
}
