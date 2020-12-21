package leetcode.leetcode16xx.leetcode1639;

import java.util.Arrays;

public class Solution {
    public static final int p = 1_000_000_007;

    public int numWays(String[] words, String target) {
        int n = target.length();
        if (n == 0) return 1;
        if (words.length == 0) return 0;
        int m = words[0].length();
        if (m < n) return 0;
        int[][] counts = new int[26][m];
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                counts[word.charAt(i) - 'a'][i]++;
            }
        }

        long[] prev = new long[m + 1], next = new long[m + 1];
        Arrays.fill(prev, 1);

        for (int i = 0; i < n; i++) {
            int c = target.charAt(i) - 'a';
            next[0] = 0;
            for (int j = 0; j < m; j++) {
                next[j + 1] = (counts[c][j] * prev[j] + next[j]) % p;
            }
            long[] tmp = prev;
            prev = next;
            next = tmp;
        }
        return (int) prev[m];
    }
}
