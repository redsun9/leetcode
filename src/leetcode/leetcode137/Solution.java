package leetcode.leetcode137;

public class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (num & (1 << i)) >> i;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += (bits[i] % 3) << i;
        }
        return ans;
    }
}
