package leetcode.leetcode7xx.leetcode771;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char c : J.toCharArray())
            if (c >= 'a' && c <= 'z') {
                lower[c - 'a'] = true;
            } else upper[c - 'A'] = true;

        int count = 0;
        for (char c : S.toCharArray())
            if (c >= 'a' && c <= 'z') {
                if (lower[c - 'a']) count++;
            } else if (upper[c - 'A']) count++;
        return count;
    }
}
