package codeforces.contest1339;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            int ans = 0;
            for (int j = 1; j < n; j++) {
                if (a[j] < a[j - 1]) {
                    if (a[j] + (1L << ans) - 1 < a[j - 1]) {
                        ans = 64 - Long.numberOfLeadingZeros(a[j - 1] - a[j]);
                    }
                    a[j] = a[j - 1];
                }
            }
            System.out.println(ans);
        }
    }
}
