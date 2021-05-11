package leetcode.leetcode18xx.leetcode1844;

public class Solution {
    public String replaceDigits(String s) {
        char[] ans = s.toCharArray();
        int n = s.length();
        for (int i = 1; i < n; i += 2) ans[i] += ans[i - 1] - '0';
        return new String(ans);
    }
}
