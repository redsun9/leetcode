package tinkoff.XorCombination;

import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class Solution {
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


        // inversed[i] - a modular multiplicative inverse of i modulo p
        // i*inversed[i] = 1(mod p)
        int[] inversed = new int[n + 1];
        for (int i = 1; i <= n; i++) inversed[i] = reverse(i);

        // b[i] = a binomial coefficient = C(n;i) mod p
        // b[i] - number of ways to choose i elements from n
        long[] binomial = new long[n + 1];
        binomial[0] = 1;
        for (int i = 1, k = n; i <= n; i++, k--) binomial[i] = binomial[i - 1] * inversed[i] % p * k % p;
        return dfs(n, m, Integer.highestOneBit(m) >>> 1, binomial);
    }

    private static int dfs(int n, int m, int weight, long[] bc) {
        if (weight == 0 && m == 0) return 1;
        if (weight <= 0) return 0;

        long ans = 0;
        int nextWeight = weight >>> 1;
        for (int i = 0; i <= n && m >= 0; i += 2, m -= 2 * weight) {
            ans = ans + bc[i] * dfs(n, m, nextWeight, bc);
            if (ans >= p) ans %= p;
        }
        return (int) (ans);
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
