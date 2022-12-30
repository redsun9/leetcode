package codeforces.contest1476;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] costs = new int[n];
            for (int i = 0; i < n; i++) costs[i] = scanner.nextInt();
            long ans = solve(k, costs);
            System.out.println(ans);
        }
    }


    private static long solve(long k, int[] p) {
        int n = p.length;
        long[] c = new long[n];
        c[0] = p[0];
        for (int i = 1; i < n; i++) c[i] = c[i - 1] + p[i];
        long ans = 0;
        for (int i = 1; i < n; i++) ans = Math.max(ans, (100L * (c[i] - c[i - 1]) - c[i - 1] * k + k - 1) / k);
        return ans;
    }
}
