package leetcode.leetcode2xx.leetcode233;

public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int tmp = n;
        long c = 1, ans = 0;
        while (tmp != 0) {
            int digit = tmp % 10;
            ans += (tmp /= 10) * c;
            if (digit > 1) {
                ans += c;
            } else if (digit == 1) {
                ans += n % c + 1;
            }
            c *= 10;
        }
        return (int) ans;
    }
}
