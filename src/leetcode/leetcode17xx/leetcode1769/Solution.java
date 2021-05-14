package leetcode.leetcode17xx.leetcode1769;

public class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int s = 0;
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            int a = boxes.charAt(i) - '0';
            right += a;
            s += i * a;
        }
        int[] ans = new int[n];
        ans[0] = s;
        for (int i = 1; i < n; i++) {
            left += boxes.charAt(i - 1) - '0';
            s += left - right;
            ans[i] = s;
            right -= boxes.charAt(i) - '0';
        }
        return ans;
    }
}
