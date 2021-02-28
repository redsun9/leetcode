package leetcode.leetcode17xx.leetcode1758;

public class Solution {
    public int minOperations(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += (s.charAt(i) ^ i) & 1;
        }
        return Math.min(cnt, s.length() - cnt);
    }
}
