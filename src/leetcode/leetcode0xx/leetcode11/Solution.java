package leetcode.leetcode0xx.leetcode11;

public class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0, j = height.length - 1; i != j; ) {
            if (height[i] < height[j]) {
                ans = Math.max(ans, height[i] * (j - i));
                i++;
            } else {
                ans = Math.max(ans, height[j] * (j - i));
                j--;
            }
        }
        return ans;
    }
}
