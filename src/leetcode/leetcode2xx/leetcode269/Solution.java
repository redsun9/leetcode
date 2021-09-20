package leetcode.leetcode2xx.leetcode269;

import java.util.PriorityQueue;

public class Solution {
    private static final int maxAlphabetSize = 26;

    public String alienOrder(String[] words) {
        int n = words.length;
        boolean[] meet = new boolean[maxAlphabetSize];
        int alphabetSize = 0;

        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                int c = word.charAt(i) - 'a';
                if (!meet[c]) {
                    alphabetSize++;
                    meet[c] = true;
                }
            }
        }

        char[] ans = new char[alphabetSize];

        if (n <= 1) {
            int i = 0, j = 0;
            while (j < alphabetSize) {
                if (meet[i]) ans[j++] = (char) ('a' + i);
                i++;
            }
            return new String(ans);
        }

        int[][] adj = new int[maxAlphabetSize][maxAlphabetSize];
        int[] inDegree = new int[maxAlphabetSize];

        for (int i = 1; i < n; i++) {
            String s = words[i - 1], t = words[i];
            int len1 = s.length(), len2 = t.length(), minLen = Math.min(len1, len2), j = 0;
            while (j < minLen && s.charAt(j) == t.charAt(j)) j++;
            if (j == len2 && j < len1) return "";
            if (j < minLen) {
                int c1 = s.charAt(j) - 'a', c2 = t.charAt(j) - 'a';
                adj[c1][c2]++;
                inDegree[c2]++;
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int pos = 0;
        for (int i = 0; i < maxAlphabetSize; i++) if (meet[i] && inDegree[i] == 0) queue.offer(i);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            ans[pos++] = (char) ('a' + i);
            for (int j = 0; j < maxAlphabetSize; j++) {
                if (adj[i][j] != 0) {
                    inDegree[j] -= adj[i][j];
                    if (inDegree[j] == 0) queue.offer(j);
                }
            }
        }

        if (pos != alphabetSize) return "";
        else return new String(ans);
    }
}
