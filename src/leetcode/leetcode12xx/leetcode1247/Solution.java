package leetcode.leetcode12xx.leetcode1247;

public class Solution {
    public int minimumSwap(String s1, String s2) {
        int n = s1.length();
        int xy = 0, yx = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') xy++;
                else yx++;
            }
        }
        return ((xy ^ yx) & 1) == 0 ? ((xy + yx) >>> 1) + (xy & 1) : -1;
    }
}
