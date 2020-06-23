package atcoder.dp;

import java.util.Scanner;

public class ProblemF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(lcs(s, t));
    }


    private static String lcs(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        int length = dp[m][n];
        char[] ans = new char[length];
        for (int i = m - 1, j = n - 1; length > 0; ) {
            if (s.charAt(i) == t.charAt(j)) {
                ans[--length] = s.charAt(i);
                i--;
                j--;
            } else if (dp[i + 1][j] > dp[i][j + 1]) j--;
            else i--;
        }
        return new String(ans);
    }
}
