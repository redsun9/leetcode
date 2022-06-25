package leetcode.leetcode23xx.leetcode2317;

public class Solution {
    public int maximumXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) ans |= num;
        return ans;
    }
}
