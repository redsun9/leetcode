package codeforces.contest1711;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            int[][] pairs = new int[m][2];
            for (int i = 0; i < m; i++) {
                pairs[i][0] = scanner.nextInt();
                pairs[i][1] = scanner.nextInt();
            }
            System.out.println(solve(a, pairs));
        }
    }

    private static int solve(int[] a, int[][] pairs) {
        if (pairs.length % 2 == 0) return 0;
        int n = a.length;
        boolean[] cnt = new boolean[n];
        for (int[] pair : pairs) {
            cnt[pair[0] - 1] ^= true;
            cnt[pair[1] - 1] ^= true;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) if (cnt[i]) ans = Math.min(ans, a[i]);
        for (int[] pair : pairs) {
            int u = pair[0] - 1, v = pair[1] - 1;
            if (!cnt[u] && !cnt[v]) ans = Math.min(ans, a[u] + a[v]);
        }
        return ans;
    }
}
