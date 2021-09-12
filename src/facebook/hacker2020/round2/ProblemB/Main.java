package facebook.hacker2020.round2.ProblemB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2020/round2/ProblemB/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2020/round2/ProblemB/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= t; i++) {
                String s[] = scanner.nextLine().split(" ");
                int n = Integer.parseInt(s[0]);
                double p = Double.parseDouble(s[1]);

                double[] ans = solve(n, p);
                printer.println("Case #" + i + ": ");
                for (int j = 0; j < n; j++) printer.println(ans[j]);
            }
        }
    }


    static double[] solve(int n, double p) {
        double q = 1 - p;
        double[][] dp = new double[n][n];
        for (int left = 2; left <= n; left++) {
            int totalCombinations = left * (left - 1) / 2;
            for (int w = 0, s = left - 1; s >= 0; w++, s--) {
                double sum = 0;
                if (w >= 2) sum += w * (w - 1) / 2 * dp[w - 1][s];
                if (s >= 2) sum += s * (s - 1) / 2 * dp[w][s - 1];
                if (w > 0 && s > 0) sum += w * s * (p * dp[w - 1][s] + q * dp[w][s - 1]);
                if (w > 0) sum += w * p * dp[w - 1][s];
                if (s > 0) sum += s * q * dp[w][s - 1];
                sum /= totalCombinations;
                sum += 1;
                dp[w][s] = sum;
            }
        }
        double[] ans = new double[n];
        for (int i = 0; i < n; i++) ans[i] = dp[i][n - 1 - i];
        return ans;
    }
}
