package atcoder.abc162;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (n == 2) {
            System.out.println(max(a[0], a[1]));
            return;
        }
        if (n == 3) {
            System.out.println(max(a[0], a[1], a[2]));
            return;
        }
        if (n % 2 == 0) {
            long[] dp = new long[n];
            dp[0] = a[0];
            dp[1] = a[1];
            for (int i = 2; i < n; i++) {
                if (i % 2 == 0) {
                    dp[i] = a[i] + dp[i - 2];
                } else {
                    dp[i] = a[i] + max(dp[i - 2], dp[i - 3]);
                }
            }
            System.out.println(max(dp[n - 1], dp[n - 2]));
        } else {
            long[][] dp = new long[3][n];
            for (int i = 0; i < 3; i++) {
                Arrays.fill(dp[i], Long.MIN_VALUE);
            }
            dp[0][0] = a[0];
            dp[1][1] = a[1];
            dp[0][2] = a[0] + a[2];
            dp[2][2] = a[2];
            for (int i = 3; i < n; i++) {
                if (i % 2 == 0) {
                    dp[0][i] = a[i] + dp[0][i - 2];
                    dp[2][i] = a[i] + max(dp[2][i - 2], dp[1][i - 3], dp[0][i - 4]);
                } else {
                    dp[1][i] = a[i] + max(dp[1][i - 2], dp[0][i - 3]);
                }
            }
            System.out.println(max(dp[2][n - 1], dp[1][n - 2], dp[0][n - 3]));
        }
    }

    private static int max(int... a) {
        int max = a[0];
        for (int i : a) {
            if (i > max) max = i;
        }
        return max;
    }

    private static long max(long... a) {
        long max = a[0];
        for (long i : a) {
            if (i > max) max = i;
        }
        return max;
    }
}
