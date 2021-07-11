package leetcode.leetcode17xx.leetcode1750;

public class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (true) {
            if (i == j) return 1;
            char c = s.charAt(i);
            if (c == s.charAt(j)) {
                while (i < j && s.charAt(i) == c) i++;
                if (i == j) return 0;
                while (s.charAt(j) == c) j--;
            } else return j - i + 1;
        }
    }
}
