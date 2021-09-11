package facebook.hacker2021.round1.ProblemB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2021/round1/ProblemB/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2021/round1/ProblemB/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int test = 1; test <= t; test++) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (a < m + n - 1 || b < m + n - 1) {
                    printer.println("Case #" + test + ": Impossible");
                } else {
                    printer.println("Case #" + test + ": Possible");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (j != 0) printer.print(' ');
                            if (i == 0 && j == 0) printer.print(a + 2 - m - n);
                            else if (i == 0 && j == m - 1) printer.print(b + 2 - m - n);
                            else if (i == n - 1 || j == 0 || j == m - 1) printer.print(1);
                            else printer.print(1000);
                        }
                        printer.println();
                    }
                }
            }
        }
    }
}
