package leetcode.leetcode18xx.leetcode1876;

public class Solution {
    public int countGoodSubstrings(String s) {
        int n = s.length();
        if (n <= 2) return 0;
        int ans = 0;
        char a = s.charAt(n - 2), b = s.charAt(n - 1), c;
        n -= 3;
        while (n >= 0) {
            c = b;
            b = a;
            a = s.charAt(n--);
            if (a != b && b != c && a != c) ans++;
        }
        return ans;
    }
}
