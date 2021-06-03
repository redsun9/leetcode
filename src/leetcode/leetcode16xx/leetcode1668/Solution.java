package leetcode.leetcode16xx.leetcode1668;

import java.util.Arrays;

public class Solution {
    public int maxRepeating(String s, String w) {
        int m = s.length();
        int n = w.length();

        int[] pref = new int[n];
        Arrays.fill(pref, -1);
        for (int i = 1; i < n; i++) {
            int j = pref[i - 1];
            while (j != -1 && w.charAt(j + 1) != w.charAt(i)) j = pref[j];
            if (w.charAt(j + 1) == w.charAt(i)) j++;
            pref[i] = j;
        }

        int ans = 0;
        int j = 0;
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == w.charAt(j)) {
                if (j == n - 1) {
                    v[i] = 1 + (i < n ? 0 : v[i - n]);
                    ans = Math.max(ans, v[i]);
                    j = pref[j];
                }
            } else {
                j--;
                while (j != -1 && w.charAt(j + 1) != s.charAt(i)) j = pref[j];
                if (w.charAt(j + 1) == s.charAt(i)) j++;
            }
            j++;
        }
        return ans;
    }
}
