package leetcode.leetcode15xx.leetcode1598;

public class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            switch (log) {
                case "../" -> ans = Math.max(0, ans - 1);
                case "./" -> {
                }
                default -> ans++;
            }
        }
        return ans;
    }
}
