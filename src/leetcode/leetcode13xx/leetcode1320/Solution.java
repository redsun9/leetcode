package leetcode.leetcode13xx.leetcode1320;

import java.util.Arrays;

public class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        if (n <= 2) return 0;
        int[][] dist = new int[26][26];
        for (int i = 0; i < 26; i++) {
            int a = i % 6;
            int b = i / 6;
            for (int j = 0; j < 26; j++) {
                int c = j % 6;
                int d = j / 6;
                dist[i][j] = Math.abs(a - c) + Math.abs(b - d);
            }
        }
        char[] chars = word.toCharArray();
        int[] prev = new int[26];
        int[] next = new int[26];

        for (int i = 1; i < n; i++) {
            int[] tmp = next;
            next = prev;
            prev = tmp;
            Arrays.fill(next, Integer.MAX_VALUE);

            int prevChar = chars[i - 1] - 'A';
            int nextChar = chars[i] - 'A';
            for (int j = 0; j < 26; j++) {
                next[j] = Math.min(next[j], prev[j] + dist[prevChar][nextChar]);
                next[prevChar] = Math.min(next[prevChar], prev[j] + dist[j][nextChar]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int a : next) {
            min = Math.min(min, a);
        }
        return min;
    }
}
