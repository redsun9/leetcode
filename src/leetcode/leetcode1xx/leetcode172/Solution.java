package leetcode.leetcode1xx.leetcode172;

public class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) ans += (n /= 5);
        return ans;
    }
}
