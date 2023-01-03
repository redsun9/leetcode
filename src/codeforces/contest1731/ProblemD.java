package codeforces.contest1731;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] a = new int[m][n];
            for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) a[i][j] = scanner.nextInt();
            System.out.println(solve(a));
        }
    }

    private static int solve(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int lo = 1, hi = Math.min(m, n);
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (check(a, m, n, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private static boolean check(int[][] a, int m, int n, int val) {
        int[] prev = new int[n + 1], next = new int[n + 1], tmp;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] >= val) {
                    next[j + 1] = Math.min(prev[j], Math.min(next[j], prev[j + 1])) + 1;
                    if (next[j + 1] >= val) return true;
                } else next[j + 1] = 0;
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }
        return false;
    }

}
