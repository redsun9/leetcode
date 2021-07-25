package leetcode.leetcode19xx.leetcode1945;

public class Solution {
    public int getLucky(String s, int k) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - 'a' + 1;
            ans += d / 10 + d % 10;
        }

        while (--k != 0 && ans >= 10) {
            int tmp = 0;
            while (ans != 0) {
                tmp += ans % 10;
                ans /= 10;
            }
            ans = tmp;
        }
        return ans;
    }
}
