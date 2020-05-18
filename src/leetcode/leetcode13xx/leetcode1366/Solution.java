package leetcode.leetcode13xx.leetcode1366;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String rankTeams(String[] votes) {
        int m = votes.length;
        if (m == 1) return votes[0];
        int n = votes[0].length();
        int[][] count = new int[26][26];
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                int c = vote.charAt(i) - 'A';
                count[c][i]++;
            }
        }
        Integer[] indices = new Integer[26];
        for (int i = 0; i < 26; i++) {
            indices[i] = i;
        }
        Comparator<Integer> comp = (a, b) -> {
            int[] first = count[a];
            int[] second = count[b];
            for (int i = 0; i < 26; i++) {
                if (first[i] > second[i]) return -1;
                if (first[i] < second[i]) return 1;
            }
            return a - b;
        };
        Arrays.sort(indices, comp);
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append((char) ('A' + indices[i]));
        }
        return sb.toString();
    }
}
