package leetcode.leetcode17xx.leetcode1720;

public class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] ans = new int[n + 1];
        ans[0] = first;
        for (int i = 0; i < n; i++) {
            ans[i + 1] = encoded[i] ^ ans[i];
        }
        return ans;
    }
}
