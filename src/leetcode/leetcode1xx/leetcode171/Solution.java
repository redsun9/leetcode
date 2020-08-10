package leetcode.leetcode1xx.leetcode171;

public class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) ans = ans * 26 + (s.charAt(i) - 'A' + 1);
        return ans;
    }
}
