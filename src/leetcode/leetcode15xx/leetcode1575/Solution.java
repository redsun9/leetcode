package leetcode.leetcode15xx.leetcode1575;

public class Solution {
    public static final int p = 1_000_000_007;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dp = new int[fuel + 1][n];
        dp[fuel][start] = 1;
        for (int f = fuel; f > 0; f--) {
            for (int fromLocation = 0; fromLocation < n; fromLocation++) {
                if (dp[f][fromLocation] != 0) {
                    for (int toLocation = 0; toLocation < n; toLocation++) {
                        if (fromLocation == toLocation) continue;
                        int dist = Math.abs(locations[fromLocation] - locations[toLocation]);
                        if (dist <= f) {
                            dp[f - dist][toLocation] = (dp[f - dist][toLocation] + dp[f][fromLocation]) % p;
                        }
                    }
                }
            }
        }
        long ans = 0;
        for (int f = 0; f <= fuel; f++) {
            ans += dp[f][finish];
        }
        return (int) (ans % p);
    }
}
