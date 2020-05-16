package leetcode.leetcode14xx.leetcode1446;

public class Solution {
    public int maxPower(String s) {
        int n = s.length();
        int ans = 0;
        char prev = ' ';
        int tmp = 0;
        for (char c : s.toCharArray()) {
            if (c == prev) tmp++;
            else {
                ans = Math.max(ans, tmp);
                tmp = 1;
            }
            prev = c;
        }
        return Math.max(ans, tmp);
    }
}
