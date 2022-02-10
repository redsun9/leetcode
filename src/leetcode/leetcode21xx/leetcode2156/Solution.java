package leetcode.leetcode21xx.leetcode2156;

public class Solution {
    public String subStrHash(String s, int base, int modulo, int k, int hashValue) {
        int n = s.length(), ans = n - k;
        long curHash = 0, power = 1;
        for (int i = n - 1, j = 0; j < k; i--, j++) {
            curHash = curHash * base + s.charAt(i) - 'a' + 1;
            if (curHash >= modulo) curHash %= modulo;
            power = power * base;
            if (power >= modulo) power %= modulo;
        }

        for (int i1 = n - k - 1, i2 = n - 1; i1 >= 0; i1--, i2--) {
            curHash = curHash * base + s.charAt(i1) - 'a' + 1 - (s.charAt(i2) - 'a' + 1) * power;
            curHash %= modulo;
            if (curHash < 0) curHash += modulo;
            if (curHash == hashValue) ans = i1;
        }

        return s.substring(ans, ans + k);
    }
}
