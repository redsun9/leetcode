package leetcode.leetcode18xx.leetcode1869;

public class Solution {
    public boolean checkZeroOnes(String s) {
        int n = s.length();
        if (n == 0) return false;
        int maxOne = 0, maxZero = 0;
        int right = 0;
        while (right < n) {
            int left = right;
            char prev = s.charAt(left);
            while (right < n && s.charAt(right) == prev) right++;
            if (prev == '0') maxZero = Math.max(maxZero, right - left);
            else maxOne = Math.max(maxOne, right - left);
        }
        return maxOne > maxZero;
    }
}
