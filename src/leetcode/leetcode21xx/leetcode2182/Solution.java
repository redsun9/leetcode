package leetcode.leetcode21xx.leetcode2182;

import java.util.Arrays;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int n = s.length();
        if (n <= 1) return s;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;

        char[] ans = new char[n];
        int ansLength = 0;

        int i1 = 25, i2 = 26; // largest and second largest symbol
        while (true) {
            while (i1 >= 0 && count[i1] == 0) i1--;
            if (i1 < 0) break;

            int currentUsed = Integer.min(count[i1], repeatLimit);
            Arrays.fill(ans, ansLength, ansLength + currentUsed, (char) ('a' + i1));
            count[i1] -= currentUsed;
            ansLength += currentUsed;

            // highest letter is over
            if (count[i1] == 0) {
                i1--;
                continue;
            }

            i2 = Math.min(i1 - 1, i2);
            while (i2 >= 0 && count[i2] == 0) i2--;
            if (i2 < 0) break;
            ans[ansLength++] = (char) ('a' + i2);
            count[i2]--;
        }
        return new String(ans, 0, ansLength);
    }
}
