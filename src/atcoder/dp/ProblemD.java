package atcoder.dp;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        long[] dp = new long[w + 1];
        for (int i = 0; i < n; i++) {
            int wi = scanner.nextInt();
            long vi = scanner.nextInt();
            for (int j = w, k = w - wi; k >= 0; j--, k--) {
                dp[j] = Math.max(dp[j], dp[k] + vi);
            }
        }
        long ans = 0;
        for (long a : dp) ans = Math.max(ans, a);
        System.out.println(ans);
    }
}
