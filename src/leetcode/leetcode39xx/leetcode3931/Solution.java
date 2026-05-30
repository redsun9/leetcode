package leetcode.leetcode39xx.leetcode3931;

public class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (Math.abs(s.charAt(i - 1) - s.charAt(i)) > 2) return false;
        }
        return true;
    }
}
