package codeforces.contest1795;

import java.util.Scanner;

public class ProblemD {
    private static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long ans = 1;
        for (int i = 0; i < n; i += 3) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            if (x == y && y == z) ans = ans * 3 % MOD;
            else if (x == y && x < z || x == z && x < y || y == z && y < x) ans = ans * 2 % MOD;
        }
        int r = n / 3;
        int k = n / 6;
        for (int i = 1, j = r; i <= k; i++, j--) ans = ans * j % MOD * reverse(i) % MOD;
        System.out.println(ans);
    }

    public static int reverse(int a) {
        int t = 0, newT = 1, r = MOD, newR = a, q, tmp;
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
        if (t < 0) t += MOD;
        return t;
    }
}
