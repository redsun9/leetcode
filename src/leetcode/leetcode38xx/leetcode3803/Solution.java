package leetcode.leetcode38xx.leetcode3803;

public class Solution {
    public int residuePrefixes(String s) {
        int n = s.length();
        if (n <= 1) return n;

        int ans = 1;
        char a = s.charAt(0);
        int i2 = 1;

        while (i2 < n && s.charAt(i2) == a) if (++i2 % 3 == 1) ans++;
        if (i2 == n) return ans;

        char b = s.charAt(i2);
        int i3 = i2;
        while (i3 < n && (s.charAt(i3) == a || s.charAt(i3) == b)) if (++i3 % 3 == 2) ans++;

        return ans;
    }
}
