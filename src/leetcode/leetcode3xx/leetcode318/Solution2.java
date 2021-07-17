package leetcode.leetcode3xx.leetcode318;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public int maxProduct(String[] words) {
        int n = words.length;
        if (n < 2) return 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            int mask = 0;
            for (int j = 0; j < m; j++) mask |= 1 << (word.charAt(j) - 'a');
            masks[i] = mask;
        }
        int ans = 0;
        for (int i = n - 1; i >= 1; i--) {
            int si = words[i].length();
            if (si * si <= ans) break;
            for (int j = i - 1; j >= 0; j--) {
                int sj = words[j].length();
                if (si * sj <= ans) break;
                if ((masks[i] & masks[j]) == 0) ans = si * sj;
            }
        }
        return ans;

    }
}
