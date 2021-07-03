package leetcode.leetcode5xx.leetcode522;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Solution {
    private static boolean isSubsequence(String small, String big) {
        int m = small.length(), n = big.length();
        int i = 0, j = 0;
        while (i < m && j < n) if (small.charAt(i) == big.charAt(j++)) i++;
        return i == m;
    }

    public int findLUSlength(String[] strs) {
        int m = strs.length;
        boolean[] skip = new boolean[m];
        Arrays.sort(strs, Comparator.comparingInt(String::length).thenComparing(Function.identity()));
        int i = m - 1;
        while (i >= 0) {
            if (i > 0 && strs[i - 1].equals(strs[i])) {
                skip[i - 1] = true;
            } else if (!skip[i]) {
                for (int j = i + 1; j < m; j++) {
                    if (!skip[j] && isSubsequence(strs[i], strs[j])) {
                        skip[i] = true;
                        break;
                    }
                }
                if (!skip[i]) return strs[i].length();
            }
            i--;
        }
        return -1;
    }
}
