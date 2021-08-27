package facebook.hacker2021.qual.ProblemB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings("UnnecessarySemicolon")
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2021/qual/ProblemB/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2021/qual/ProblemB/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            int numberOfTests = Integer.parseInt(scanner.nextLine());
            for (int test = 1; test <= numberOfTests; test++) {
                int n = Integer.parseInt(scanner.nextLine());
                int[] r1 = new int[n], c1 = new int[n];
                boolean[] r2 = new boolean[n], c2 = new boolean[n];
                boolean[][] f = new boolean[n][n];
                for (int i = 0; i < n; i++) {
                    String s = scanner.nextLine();
                    for (int j = 0; j < n; j++) {
                        if (s.charAt(j) == 'X') {
                            r1[i]++;
                            c1[j]++;
                        } else if (s.charAt(j) == 'O') {
                            r2[i] = true;
                            c2[j] = true;
                        } else {
                            f[i][j] = true;
                        }
                    }
                }

                int[] ans = solve(n, r1, c1, r2, c2, f);
                if (ans[0] == -1) {
                    printer.println("Case #" + test + ": Impossible");
                } else {
                    printer.println("Case #" + test + ": " + ans[0] + " " + ans[1]);
                }
            }
        }
    }

    private static int[] solve(int n, int[] r1, int[] c1, boolean[] r2, boolean[] c2, boolean[][] f) {
        int max = -1, countMax = 0;
        for (int i = 0; i < n; i++) {
            if (!r2[i]) {
                if (r1[i] > max) {
                    max = r1[i];
                    countMax = 1;
                } else if (r1[i] == max) countMax++;
            }
            if (!c2[i]) {
                if (c1[i] > max) {
                    max = c1[i];
                    countMax = 1;
                } else if (c1[i] == max) countMax++;
            }
        }

        if (max == -1) return new int[]{-1, countMax};
        if (max != n - 1) return new int[]{n - max, countMax};

        for (int i = 0; i < n; i++) {
            if (r1[i] != max || r2[i]) continue;
            for (int j = 0; j < n; j++) {
                if (f[i][j] && !c2[j] && c1[j] == max) countMax--;
            }
        }
        return new int[]{n - max, countMax};
    }
}
