package leetcode.leetcode4xx.leetcode459;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n < 2) return false;
        char[] chars = s.toCharArray();
        int tmp = n;
        if (tmp % 2 == 0) {
            if (check(chars, 2, n)) return true;
            while (tmp % 2 == 0) tmp /= 2;
        }
        for (int i = 3; i * i <= tmp; i += 2) {
            if (tmp % i != 0) continue;
            if (check(chars, i, n)) return true;
            while (tmp % i == 0) tmp /= i;
        }
        return tmp != 1 && check(chars, tmp, n);
    }

    private static boolean check(char[] s, int k, int n) {
        int t = n / k;
        for (int j = 1; j < k; j++) {
            for (int i = 0; i < t; i++) {
                if (s[i] != s[j * t + i]) return false;
            }
        }
        return true;
    }
}
