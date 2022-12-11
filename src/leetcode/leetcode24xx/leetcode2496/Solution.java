package leetcode.leetcode24xx.leetcode2496;

public class Solution {
    public int maximumValue(String[] strs) {
        int ans = 0;
        for (String str : strs) {
            int num = 0, n = str.length();
            for (int i = 0; i < n; i++) {
                int c = str.charAt(i) - '0';
                if (c >= 0 && c <= 9) num = num * 10 + c;
                else {
                    num = n;
                    break;
                }
            }
            ans = Math.max(ans, num);
        }
        return ans;
    }
}
