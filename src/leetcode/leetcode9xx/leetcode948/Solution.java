package leetcode.leetcode9xx.leetcode948;

import java.util.Arrays;

public class Solution {
    public int bagOfTokensScore(int[] tokens, int p) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1, ans = 0;
        int cur = 0;
        while (true) {
            while (i <= j && p >= tokens[i]) {
                p -= tokens[i];
                i++;
                cur++;
            }
            ans = Math.max(ans, cur);
            if (cur != 0 && i < j && tokens[i] < tokens[j]) {
                p += tokens[j];
                j--;
                cur--;
            } else break;
        }
        return ans;
    }
}
