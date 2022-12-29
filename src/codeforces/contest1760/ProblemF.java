package codeforces.contest1760;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            long c = scanner.nextLong();
            int d = scanner.nextInt();
            int[] quests = new int[n];
            for (int i = 0; i < n; i++) quests[i] = scanner.nextInt();
            int ans = solve(quests, d, c);
            if (ans < 0) System.out.println("Impossible");
            else if (ans > d) System.out.println("Infinity");
            else System.out.println(ans);
        }
    }

    private static int solve(int[] quests, int d, long c) {
        int n = quests.length;
        Arrays.sort(quests);
        if ((long) quests[n - 1] * d < c) return -1;
        long[] prefSum = new long[n + 1];
        for (int i = 0, j = n - 1; i < n; i++, j--) prefSum[i + 1] = prefSum[i] + quests[j];
        if (n <= d && prefSum[n] >= c || n >= d && prefSum[d] >= c) return d + 1;

        int lo = 0, hi = d - 2;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (getVal(prefSum, n, d, mid) >= c) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private static long getVal(long[] pref, int n, int d, int k) {
        return pref[Math.min(n, k + 1)] * (d / (k + 1)) + pref[Math.min(n, d % (k + 1))];
    }
}
