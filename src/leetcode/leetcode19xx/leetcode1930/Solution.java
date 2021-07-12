package leetcode.leetcode19xx.leetcode1930;

import java.util.Arrays;

public class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] left = new int[26], right = new int[26];
        Arrays.fill(left, n);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            left[c] = Math.min(left[c], i);
            right[c] = i;
        }

        int ans = 0;
        boolean[] seen = new boolean[26];
        for (int borderChar = 0; borderChar < 26; borderChar++) {
            int leftPos = left[borderChar];
            if (leftPos != n) {
                Arrays.fill(seen, false);
                int rightPos = right[borderChar];
                for (int i = leftPos + 1; i < rightPos; i++) {
                    int c2 = s.charAt(i) - 'a';
                    if (!seen[c2]) {
                        ans++;
                        seen[c2] = true;
                    }
                }
            }
        }
        return ans;
    }
}
