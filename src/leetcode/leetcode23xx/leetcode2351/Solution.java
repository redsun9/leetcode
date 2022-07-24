package leetcode.leetcode23xx.leetcode2351;

public class Solution {
    public char repeatedCharacter(String s) {
        boolean[] meet = new boolean[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (meet[c - 'a']) return c;
            meet[c - 'a'] = true;
        }
        return 'a';
    }
}
