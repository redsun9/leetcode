package leetcode.leetcode17xx.leetcode1734;

public class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int a = (n & 3) == 1 ? 1 : 0;
        for (int i = 1; i < n; i += 2) a ^= encoded[i];
        int[] ans = new int[n];
        ans[0] = a;
        for (int i = 1; i < n; i++) ans[i] = ans[i - 1] ^ encoded[i - 1];
        return ans;
    }
}
