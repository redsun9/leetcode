package tinkoff.xor_combination;

import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    private final static int p = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(solve(n, m));
    }

    static int solve(int n, int m) {
        if ((m & 1) != 0) return 0;
        if (n == 1) return m == 0 ? 1 : 0;
        if (m == 0) return 1;

        // b[i] = a binomial coefficient = C(n;i) mod p
        // b[i] - number of ways to choose i elements from n
        long[] binomial = new long[n + 1];
        binomial[0] = 1;
        for (int i = 1, k = n; i <= n; i++, k--) binomial[i] = binomial[i - 1] * reverse(i) % p * k % p;

        int positionOfHighestOneBit = 31 - Integer.numberOfLeadingZeros(m);
        int[][] cache = new int[positionOfHighestOneBit][m + 1];
        return dfs(n, m, positionOfHighestOneBit - 1, binomial, cache);
    }

    private static int dfs(int n, int m, int k, long[] bc, int[][] cache) {
        if (k == 0) return m <= n ? (int) bc[m] : 0;
        if (cache[k][m] == 0) {
            long ans = 0;
            int weight = 2 << k;
            for (int i = 0, left = m; i <= n && left >= 0; i += 2, left -= weight) {
                ans = ans + bc[i] * dfs(n, left, k - 1, bc, cache);
                if (ans >= p) ans %= p;
            }
            cache[k][m] = (int) (ans + 1);
        }
        return cache[k][m] - 1;
    }


    // generalized Euclidean algorithm
    private static int reverse(int a) {
        int t = 0, newT = 1, r = p, newR = a, q, tmp;
        while (newR != 0) {
            q = r / newR;
            tmp = t - q * newT;
            t = newT;
            newT = tmp;
            tmp = r - q * newR;
            r = newR;
            newR = tmp;
        }
        if (r > 1) return -1;
        if (t < 0) t += p;
        return t;
    }

}
