package leetcode.leetcode24xx.leetcode2451;

import java.util.Arrays;

public class Solution {
    public String oddString(String[] words) {
        int n = words.length;
        int[] a = f(words[0]), b = f(words[1]), c = f(words[2]);
        if (!Arrays.equals(a, b)) {
            if (!Arrays.equals(a, c)) return words[0];
            else return words[1];
        } else if (!Arrays.equals(a, c)) return words[2];

        for (int i = n - 1; i > 3; i--) if (!Arrays.equals(a, f(words[i]))) return words[i];
        return words[3];
    }

    private static int[] f(String s) {
        int n = s.length();
        int[] ans = new int[n - 1];
        for (int i = 1; i < n; i++) ans[i - 1] = s.charAt(i) - s.charAt(i - 1);
        return ans;
    }
}
