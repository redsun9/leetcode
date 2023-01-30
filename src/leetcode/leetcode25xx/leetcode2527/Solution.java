package leetcode.leetcode25xx.leetcode2527;

public class Solution {
    public int xorBeauty(int[] nums) {
        int ans = 0;
        for (int num : nums) ans ^= num;
        return ans;
    }
}
