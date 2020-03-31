package leetcode.leetcode8xx.leetcode859;

public class Solution {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] count = new int[26];
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int diff = 0;
        char diffA = '0', diffB = '0';
        boolean hasDuplicateChars = false;
        int n = a.length();
        for (int i = 0; i < n; i++) {
            char cA = aChars[i];
            char cB = bChars[i];
            if (cA != cB) {
                if (diff == 0) {
                    diffA = cA;
                    diffB = cB;
                } else if (diff == 1) {
                    if (cA != diffB || cB != diffA) return false;
                } else return false;
                diff++;
            }
            if (++count[cA - 'a'] == 2) hasDuplicateChars = true;
        }
        return diff == 0 && hasDuplicateChars || diff == 2;
    }
}
