package leetcode.leetcode3xx.leetcode338;

public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) ans[i] = ans[i >> 1] + (i & 1);
        return ans;
    }
}
