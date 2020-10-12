package leetcode.leetcode16xx.leetcode1614;

public class Solution {
    public int maxDepth(String s) {
        int n = s.length(), ans = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case '(' -> ans = Math.max(ans, ++cur);
                case ')' -> cur--;
                default -> {
                }
            }
        }
        return ans;
    }
}
