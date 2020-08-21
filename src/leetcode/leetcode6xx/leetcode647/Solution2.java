package leetcode.leetcode6xx.leetcode647;

// Time complexity - O(n^2) in the worst case

public class Solution2 {
    public int countSubstrings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int ans = 0;
        for (int i = 0; i < n; i++) { // i is the mid point
            ans += dfs(s, i, i, n); // odd length;
            ans += dfs(s, i, i + 1, n); // even length
        }
        return ans;
    }

    private static int dfs(String s, int i, int j, int n) {
        int ans = 0;
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            ans++;
            i--;
            j++;
        }
        return ans;
    }
}
