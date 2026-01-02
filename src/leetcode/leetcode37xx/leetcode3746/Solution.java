package leetcode.leetcode37xx.leetcode3746;

public class Solution {
    public int minLengthAfterRemovals(String s) {
        int a = 0, b = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') a++;
            else b++;
        }
        return Math.abs(a - b);
    }
}
