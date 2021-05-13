package leetcode.leetcode18xx.leetcode1822;

public class Solution {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int num : nums) ans *= Integer.signum(num);
        return ans;
    }
}
