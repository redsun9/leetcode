package facebook.hacker2021.qual.ProblemA2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("UnnecessarySemicolon")
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2021/qual/ProblemA2/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2021/qual/ProblemA2/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= t; i++) {
                String s = scanner.nextLine();
                int len = s.length();
                int[] arr = new int[len];
                for (int j = 0; j < len; j++) arr[j] = s.charAt(j) - 'A';
                int nPairs = Integer.parseInt(scanner.nextLine());
                int[][] pairs = new int[nPairs][2];
                for (int j = 0; j < nPairs; j++) {
                    String tmp = scanner.nextLine();
                    pairs[j][0] = tmp.charAt(0) - 'A';
                    pairs[j][1] = tmp.charAt(1) - 'A';
                }
                int ans = minSubmissions(arr, pairs);
                printer.println("Case #" + i + ": " + ans);
            }
        }
    }

    private static int minSubmissions(int[] arr, int[][] pairs) {
        int[][] dp = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][i] = 0;
        }
        for (int[] pair : pairs) dp[pair[0]][pair[1]] = 1;

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (i == k || dp[i][k] == -1) continue;
                for (int j = 0; j < 26; j++) {
                    if (k == j || i == j || dp[k][j] == -1) continue;
                    if (dp[i][j] == -1 || dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        int[] count = new int[26];
        for (int a : arr) count[a]++;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            boolean ok = true;
            int tmp = 0;
            for (int j = 0; j < 26; j++) {
                if (dp[j][i] == -1 && count[j] != 0) {
                    ok = false;
                    break;
                }
                tmp += count[j] * dp[j][i];
            }
            if (ok) ans = Math.min(ans, tmp);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}
