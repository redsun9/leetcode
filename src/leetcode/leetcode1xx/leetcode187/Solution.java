package leetcode.leetcode1xx.leetcode187;

import java.util.LinkedList;
import java.util.List;

public class Solution implements RepeatedDnaSequenceFinder {
    public List<String> findRepeatedDnaSequences(String s) {
        final int bitA = 3 << 18;
        final int bitC = 2 << 18;
        final int bitG = 1 << 18;
        LinkedList<String> ans = new LinkedList<>();
        int n = s.length();
        if (n < 10) return ans;
        int[] count = new int[1 << 20];
        int seq = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            seq >>= 2;
            switch (c) {
                case 'A':
                    seq |= bitA;
                    break;
                case 'C':
                    seq |= bitC;
                    break;
                case 'G':
                    seq |= bitG;
                default:
                    break;
            }
            if (i >= 9) count[seq]++;
        }
        char[] str = new char[10];
        char[] signs = {'T', 'G', 'C', 'A'};

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                int tmp = i;
                for (int j = 0; j < 10; j++) {
                    str[j] = signs[tmp & 3];
                    tmp >>= 2;
                }
                ans.add(new String(str));
            }
        }
        return ans;
    }
}
