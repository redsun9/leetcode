package atcoder.dp;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) h[i] = scanner.nextInt();
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = Math.max(0, i - k); j < i; j++) {
                min = Math.min(min, dp[j] + Math.abs(h[i] - h[j]));
            }
            dp[i] = min;
        }
        System.out.println(dp[n - 1]);
    }
}
