package leetcode.leetcode21xx.leetcode2114;

public class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for (String sentence : sentences) {
            int tmp = 0, n = sentence.length();
            for (int i = 0; i < n; i++) if (sentence.charAt(i) == ' ') tmp++;
            if (n != 0 && tmp > ans) ans = tmp;
        }
        return ans + 1;
    }
}
