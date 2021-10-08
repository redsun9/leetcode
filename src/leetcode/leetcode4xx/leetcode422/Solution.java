package leetcode.leetcode4xx.leetcode422;

public class Solution {
    /**
     * @param words: a list of string
     * @return a boolean
     */
    public boolean validWordSquare(String[] words) {
        int n = words.length;
        if (n == 0) return true;
        for (String word : words) if (word.length() != n) return false;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < i; j++) {
                if (word.charAt(j) != words[j].charAt(i)) return false;
            }
        }
        return true;
    }
}
