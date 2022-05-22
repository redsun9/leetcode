package leetcode.leetcode22xx.leetcode2278;

public class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) if (s.charAt(i) == letter) count++;
        return count * 100 / n;
    }
}
