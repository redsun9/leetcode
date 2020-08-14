package leetcode.leetcode6xx.leetcode696;

public class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        int ans = 0;
        int previousLength = 0;
        int start = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                int currentLength = i - start;
                ans += Math.min(previousLength, currentLength);
                start = i;
                previousLength = currentLength;
            }
        }
        ans += Math.min(previousLength, n - start);
        return ans;
    }
}
