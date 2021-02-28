package leetcode.leetcode17xx.leetcode1732;

public class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int curr = 0;
        for (int a : gain) {
            curr += a;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
