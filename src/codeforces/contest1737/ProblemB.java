package codeforces.contest1737;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            long l = scanner.nextLong(), r = scanner.nextLong();
            System.out.println(solve(r) - solve(l - 1));
        }
    }

    private static long solve(long n) {
        if (n == 0) return 0;
        long x = Math.round(Math.sqrt(n));
        if (x * x > n) x--;
        long ans = 3 * (x - 1);
        if (x * x <= n) ans++;
        if (x * (x + 1) <= n) ans++;
        if (x * (x + 2) <= n) ans++;
        return ans;
    }
}
