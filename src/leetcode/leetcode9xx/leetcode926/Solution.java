package leetcode.leetcode9xx.leetcode926;

public class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                p1 = Math.min(p0, p1) + 1;
            } else {
                p1 = Math.min(p0, p1);
                p0 = p0 + 1;
            }
        }
        return Math.min(p0, p1);
    }
}
