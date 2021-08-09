package leetcode.leetcode9xx.leetcode903;

import java.util.Arrays;

public class Solution {
    private static final int p = 1_000_000_007;

    public int numPermsDISequence(String s) {
        int n = s.length();
        int[] prev = new int[n + 1], next = new int[n + 1], tmp;
        Arrays.fill(prev, 1);
        for (int i = 0, maxJ = n - 1; i < n; i++, maxJ--) {
            if (s.charAt(i) == 'I') {
                next[0] = prev[0];
                for (int j = 1; j <= maxJ; j++) {
                    next[j] = next[j - 1] + prev[j];
                    if (next[j] >= p) next[j] -= p;
                }
            } else {
                next[maxJ] = prev[maxJ + 1];
                for (int j = maxJ - 1; j >= 0; j--) {
                    next[j] = next[j + 1] + prev[j + 1];
                    if (next[j] >= p) next[j] -= p;
                }
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }
        return prev[0];
    }
}
