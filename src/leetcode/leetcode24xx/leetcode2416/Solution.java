package leetcode.leetcode24xx.leetcode2416;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int ALPHABET_SIZE = 26;

    public int[] sumPrefixScores(String[] words) {
        List<int[]> child = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        int nxt = 1;
        child.add(new int[ALPHABET_SIZE]);
        count.add(0);

        for (String word : words) {
            int len = word.length();
            int node = 0;
            for (int j = 0; j < len; j++) {
                int c = word.charAt(j) - 'a';
                if (child.get(node)[c] == 0) {
                    child.get(node)[c] = nxt++;
                    child.add(new int[ALPHABET_SIZE]);
                    count.add(0);
                }
                node = child.get(node)[c];
                count.set(node, count.get(node) + 1);
            }
        }

        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int len = word.length();
            int node = 0, sum = 0;
            for (int j = 0; j < len; j++) {
                int c = word.charAt(j) - 'a';
                node = child.get(node)[c];
                sum += count.get(node);
            }
            ans[i] = sum;
        }
        return ans;
    }
}
