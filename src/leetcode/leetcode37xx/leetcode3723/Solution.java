package leetcode.leetcode37xx.leetcode3723;

import java.util.Arrays;

public class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (num * 9 < sum) return "";
        if (num == 1) return Integer.toString(sum);
        char[] ans = new char[num];
        Arrays.fill(ans, '0');
        Arrays.fill(ans, 0, sum / 9, '9');
        if (sum % 9 != 0) ans[sum / 9] = (char) ('0' + sum % 9);
        return new String(ans);
    }
}
