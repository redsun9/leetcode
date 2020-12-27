package leetcode.leetcode16xx.leetcode1672;

public class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int[] account : accounts) {
            int tmp = 0;
            for (int a : account) tmp += a;
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}
