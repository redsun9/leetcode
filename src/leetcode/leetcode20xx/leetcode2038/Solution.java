package leetcode.leetcode20xx.leetcode2038;

public class Solution {
    public boolean winnerOfGame(String s) {
        int ans = 0, n = s.length();
        for (int i = 2; i < n; i++) {
            char c = s.charAt(i);
            if (s.charAt(i - 2) == c && s.charAt(i - 1) == c) ans += 1 - 2 * (c - 'A');
        }
        return ans > 0;
    }
}
