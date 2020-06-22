package atcoder.dp;

import java.util.Scanner;

public class ProblemE {
    public static final int MAX_COST = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int[] dp = new int[n * MAX_COST + 1];
        int s = 0;
        for (int i = 0; i < n; i++) {
            int wi = scanner.nextInt();
            int vi = scanner.nextInt();
            s += vi;
            for (int j = s, k = s - vi; k > 0; j--, k--) {
                if (dp[k] != 0) {
                    int val = dp[k] + wi;
                    if (val <= w) {
                        if (dp[j] == 0) dp[j] = val;
                        else dp[j] = Math.min(dp[j], val);
                    }
                }
            }
            if (dp[vi] == 0) dp[vi] = wi;
            else dp[vi] = Math.min(dp[vi], wi);
        }
        for (int i = s; i >= 0; i--) {
            if (dp[i] != 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
