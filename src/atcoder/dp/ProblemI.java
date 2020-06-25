package atcoder.dp;

import java.util.Scanner;

public class ProblemI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        double[] dp = new double[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            double p = Double.parseDouble(strings[i]);
            for (int j = i + 1; j > 0; j--) {
                dp[j] = dp[j] * (1 - p) + dp[j - 1] * p;
            }
            dp[0] *= (1 - p);
        }
        double ans = 0;
        for (int i = n; i > n / 2; i--) {
            ans += dp[i];
        }
        System.out.println(ans);
    }
}
