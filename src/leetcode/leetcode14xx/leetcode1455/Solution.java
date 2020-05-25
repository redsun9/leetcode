package leetcode.leetcode14xx.leetcode1455;

public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int m = sentence.length();
        int n = searchWord.length();
        if (m < n) return -1;
        int wordIndex = 1, i = 0, j = 0;
        boolean ok = true;
        while (i < m) {
            if (ok) {
                if (sentence.charAt(i) == searchWord.charAt(j)) {
                    j++;
                    if (j == n) return wordIndex;
                } else ok = false;
            } else if (sentence.charAt(i) == ' ') {
                ok = true;
                j = 0;
                wordIndex++;
            }
            i++;
        }
        return -1;
    }
}
