package atcoder.dp;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int dp1 = 0;
        int dp2 = Math.abs(h2 - h1);
        for (int i = 2; i < n; i++) {
            int h3 = scanner.nextInt();
            int dp3 = Math.min(dp1 + Math.abs(h3 - h1), dp2 + Math.abs(h3 - h2));
            h1 = h2;
            h2 = h3;
            dp1 = dp2;
            dp2 = dp3;
        }
        System.out.println(dp2);
    }
}
