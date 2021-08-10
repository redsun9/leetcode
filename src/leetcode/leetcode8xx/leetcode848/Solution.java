package leetcode.leetcode8xx.leetcode848;

public class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        char[] ans = s.toCharArray();
        for (int i = n - 1, sum = 0; i >= 0; i--) {
            sum += shifts[i];
            sum %= 26;
            ans[i] = (char) ('a' + (ans[i] - 'a' + sum) % 26);
        }
        return new String(ans);
    }
}
