package leetcode.leetcode8xx.leetcode828;

import java.util.Arrays;

public class Solution {
    public int uniqueLetterString(String s) {
        int[][] last = new int[2][26];
        Arrays.fill(last[0], -1);
        Arrays.fill(last[1], -1);
        int ans = 0, sum = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            sum = sum - (last[1][c] - last[0][c]) + (i - last[1][c]);
            last[0][c] = last[1][c];
            last[1][c] = i;
            ans += sum;
        }
        return ans;
    }
}
