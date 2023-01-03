package codeforces.contest1731;

import java.util.Scanner;

public class ProblemB {
    private static final int p = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static long solve(int n) {
        //1/6 (n-1) n (1 + 4 n)
        long ans = 1;
        boolean dividedByTwo = false, dividedByThree = false;
        long[] m = {n - 1, n, 4L * n + 1};
        for (long a : m) {
            if (!dividedByTwo && a % 2 == 0) {
                a /= 2;
                dividedByTwo = true;
            }
            if (!dividedByThree && a % 3 == 0) {
                a /= 3;
                dividedByThree = true;
            }
            ans *= a;
            if (ans >= p) ans %= p;
        }
        ans += (long) n * n;
        if (ans >= p) ans %= p;
        ans *= 2022;
        if (ans >= p) ans %= p;
        return (int) (ans);
    }
}
