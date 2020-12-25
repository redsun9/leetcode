package leetcode.leetcode16xx.leetcode1653;

public class Solution {
    public int minimumDeletions(String s) {
        int minA = 0, minB = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                minB = Math.min(minB + 1, minA);
            } else {
                minA = minA + 1;
            }
        }
        return Math.min(minA, minB);
    }
}
