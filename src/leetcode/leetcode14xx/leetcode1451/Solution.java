package leetcode.leetcode14xx.leetcode1451;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String arrangeWords(String text) {
        String[] s = text.split(" ");
        int n = s.length;
        if (n == 1) return text;
        s[0] = Character.toLowerCase(s[0].charAt(0)) + s[0].substring(1);
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(
                indices, Comparator.comparingInt((Integer pos) -> s[pos].length())
                        .thenComparingInt(pos -> pos)
        );
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(s[indices[0]].charAt(0))).append(s[indices[0]].substring(1));
        for (int i = 1; i < n; i++) {
            sb.append(' ').append(s[indices[i]]);
        }
        return sb.toString();
    }
}
