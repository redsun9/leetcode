package leetcode.leetcode8xx.leetcode833;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        int n = indexes.length;
        if (n == 0) return s;
        char[] chars = s.toCharArray();
        int length = chars.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, Comparator.comparingInt(x -> indexes[x]));
        boolean[] matched = new boolean[n];
        for (int i : order) {
            String source = sources[i];
            int sLength = source.length();
            if (indexes[i] + sLength > length) continue;
            matched[i] = true;
            for (int i1 = indexes[i], i2 = 0; i2 < sLength; i1++, i2++) {
                if (chars[i1] != source.charAt(i2)) {
                    matched[i] = false;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int offset = 0;
        for (int i : order) {
            if (matched[i]) {
                sb.append(chars, offset, indexes[i] - offset);
                sb.append(targets[i]);
                offset = indexes[i] + sources[i].length();
            }
        }
        sb.append(chars, offset, length - offset);
        return sb.toString();
    }
}
