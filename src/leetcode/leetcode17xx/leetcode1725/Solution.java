package leetcode.leetcode17xx.leetcode1725;

public class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int ans = 0;
        for (int[] rectangle : rectangles) {
            int a = Math.min(rectangle[0], rectangle[1]);
            if (a == maxLen) ans++;
            else if (a > maxLen) {
                ans = 1;
                maxLen = a;
            }
        }
        return ans;
    }
}
