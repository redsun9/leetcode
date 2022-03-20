package leetcode.leetcode22xx.leetcode2207;

public class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int n = text.length();
        char a = pattern.charAt(0), b = pattern.charAt(1);
        if (a == b) {
            int count = 1;
            for (int i = 0; i < n; i++) if (text.charAt(i) == a) count++;
            return (count - 1L) * count / 2;
        } else {
            long ans1 = 0;
            int countA = 1;
            for (int i = 0; i < n; i++) {
                if (text.charAt(i) == a) countA++;
                else if (text.charAt(i) == b) ans1 += countA;
            }
            long ans2 = 0;
            int countB = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (text.charAt(i) == b) countB++;
                else if (text.charAt(i) == a) ans2 += countB;
            }
            return Math.max(ans1, ans2);
        }
    }
}
