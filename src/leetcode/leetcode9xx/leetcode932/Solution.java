package leetcode.leetcode9xx.leetcode932;

public class Solution {
    private static void dfs(int from, int n, int[] ans) {
        if (n <= 2) {
            for (int i = 1; i <= n; i++) ans[from++] = i;
        } else {
            int oddNumber = (n + 1) >>> 1;
            int evenNumber = n >>> 1;
            dfs(from, oddNumber, ans);
            dfs(from + oddNumber, evenNumber, ans);
            for (int i = 0; i < oddNumber; i++, from++) ans[from] = (ans[from] << 1) - 1;
            for (int i = 0; i < evenNumber; i++, from++) ans[from] = ans[from] << 1;
        }
    }

    public int[] beautifulArray(int n) {
        int[] ans = new int[n];
        dfs(0, n, ans);
        return ans;
    }
}
