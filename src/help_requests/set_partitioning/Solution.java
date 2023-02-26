package help_requests.set_partitioning;

public class Solution {
    public static long numberOfPartitions(int[] sizes) {
        int totalSize = 0;
        int maxSize = 0;
        for (int size : sizes) {
            totalSize += size;
            maxSize = Math.max(maxSize, size);
        }

        long[] factorial = new long[maxSize + 1];
        factorial[0] = 1;
        for (int i = 1; i <= maxSize; i++) factorial[i] = factorial[i - 1] * i;

        long[][] c = new long[totalSize + 1][totalSize + 1];
        for (int i = 0; i <= totalSize; i++) {
            c[i][0] = 1;
            c[0][i] = 1;
            c[i][i] = 1;
        }
        for (int i = 2; i <= totalSize; i++) {
            for (int j = 1; j < i; j++) {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
            }
        }

        int n = sizes.length;
        long[][] dp = new long[n + 1][totalSize + 1];
        dp[0][0] = 1;
        for (int i = 1, max = 0, sum = 0; i <= n; i++) {
            int s = sizes[i - 1];
            for (int a = max; a <= sum; a++) {
                for (int k = Math.min(a, s); k >= 0; k--) {
                    dp[i][a + s - k] += dp[i - 1][a] * c[a][k] * c[s][k] * factorial[k];
                }
            }
            max = Math.max(max, s);
            sum += s;
        }

        long ans = 0;
        for (int i = 0; i <= totalSize; i++) ans += dp[n][i];
        return ans;
    }
}
