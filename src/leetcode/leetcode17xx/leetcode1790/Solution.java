package leetcode.leetcode17xx.leetcode1790;

public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int firstDiff = 0;
        int diffCount = 0;
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (diffCount == 2) return false;
                if (diffCount == 0) firstDiff = i;
                else if (s1.charAt(firstDiff) != c2 || s2.charAt(firstDiff) != c1) return false;
                diffCount++;
            }
        }
        return diffCount != 1;
    }
}
