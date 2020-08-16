package leetcode.leetcode13xx.leetcode1304;

public class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i1 = n / 2 - 1, i2 = (n + 1) / 2, j = 1; i1 >= 0; i1--, i2++, j++) {
            ans[i1] = -j;
            ans[i2] = j;
        }
        return ans;
    }
}
