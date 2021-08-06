package leetcode.leetcode10xx.leetcode1079;

public class Solution {
    private static int dfs(int i, int val, int len, int[] count) {
        if (i == 26) return val;
        int ans = dfs(i + 1, val, len++, count);
        for (int j = 1; j <= count[i]; j++, len++) {
            val = val * len / j;
            ans += dfs(i + 1, val, len, count);
        }
        return ans;
    }

    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) count[tiles.charAt(i) - 'A']++;
        return dfs(0, 1, 0, count) - 1;
    }
}
