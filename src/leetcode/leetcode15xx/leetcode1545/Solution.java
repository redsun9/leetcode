package leetcode.leetcode15xx.leetcode1545;

public class Solution {
    public char findKthBit(int n, int k) {
        int m = (1 << n) - 1;
        return dfs(m, k) ? '1' : '0';
    }

    private static boolean dfs(int m, int k) {
        if (m == 1) return false;
        int mid = (m + 1) / 2;
        if (k == mid) return true;
        else if (k < mid) return dfs(mid - 1, k);
        else return !dfs(mid - 1, 2 * mid - k);
    }
}
