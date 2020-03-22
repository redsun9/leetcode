package atcoder.agc043;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int h = Integer.parseInt(str[0]);
        int w = Integer.parseInt(str[1]);
        boolean[][] a = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            char[] s = scanner.nextLine().toCharArray();
            for (int j = 0; j < w; j++) {
                a[i][j] = s[j] == '.';
            }
        }
        int[][] dp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dp[i][j] = Integer.MAX_VALUE - 100;
            }
        }
        dp[0][0] = a[0][0] ? 0 : 1;
        int maxK = h - 1 + w - 1;
        for (int k = 1; k <= maxK; k++) {
            for (int i = Math.max(0, k - (w - 1)), j = k - i; i < h && j >= 0; i++, j--) {
                if (a[i][j]) {
                    if (i > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                    if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                } else {
                    if (i > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + (a[i - 1][j] ? 1 : 0));
                    if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + (a[i][j - 1] ? 1 : 0));
                }
            }
        }
        System.out.println(dp[h - 1][w - 1]);
    }
}
