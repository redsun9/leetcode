package leetcode.leetcode25xx.leetcode2544;

public class Solution {
    public int alternateDigitSum(int n) {
        int ans = 0;
        while (n != 0) {
            ans = n % 10 - ans;
            n /= 10;
        }
        return ans;
    }
}
