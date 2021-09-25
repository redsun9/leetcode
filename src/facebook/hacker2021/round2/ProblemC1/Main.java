package facebook.hacker2021.round2.ProblemC1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"UnnecessarySemicolon"})
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2021/round2/ProblemC1/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2021/round2/ProblemC1/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            int numberOfTests = Integer.parseInt(scanner.nextLine());
            for (int test = 1; test <= numberOfTests; test++) {
                String[] parts = scanner.nextLine().split(" ");
                int r = Integer.parseInt(parts[0]);
                int c = Integer.parseInt(parts[1]);
                int k = Integer.parseInt(parts[2]) - 1;
                String[] g = new String[r];
                for (int i = 0; i < r; i++) g[i] = scanner.nextLine();
                int ans = solve(g, r, c, k);
                printer.println("Case #" + test + ": " + ans);
            }
        }
    }

    private static int solve(String[] g, int r, int c, int k) {
        int[] totalCarsInRow = new int[r];
        int[][] totalCarsAbove = new int[r + 1][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (g[i].charAt(j) == 'X') {
                    totalCarsInRow[i]++;
                    totalCarsAbove[i + 1][j] = totalCarsAbove[i][j] + 1;
                } else {
                    totalCarsAbove[i + 1][j] = totalCarsAbove[i][j];
                }
            }
        }

        int ans = totalCarsInRow[k];
        if (ans <= 1) return ans;

        //move top
        if (k != 0) {
            for (int shift = 1; shift <= r - k; shift++) {
                int tmp = 0;
                for (int j = 0; j < c; j++) {
                    if (
                            (k + shift < r && g[k + shift].charAt(j) == 'X') ||
                                    totalCarsAbove[k + shift][j] > k
                    ) tmp++;
                }
                ans = Math.min(ans, shift + tmp);
            }
        }

        //move bot
        if (k != r - 1) {
            for (int shift = 1; shift <= k + 1; shift++) {
                int tmp = 0;
                for (int j = 0; j < c; j++) {
                    if (
                            (k - shift >= 0 && g[k - shift].charAt(j) == 'X') ||
                                    totalCarsAbove[r][j] - totalCarsAbove[k - shift + 1][j] >= r - k
                    ) tmp++;
                }
                ans = Math.min(ans, shift + tmp);
            }
        }

        return ans;
    }
}
