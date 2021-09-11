package facebook.hacker2021.round1.ProblemA2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    private static final int p = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2021/round1/ProblemA2/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2021/round1/ProblemA2/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= t; i++) {
                int n = Integer.parseInt(scanner.nextLine());
                String s = scanner.nextLine();
                int ans = 0, lastO = -1, lastX = -1, temp = 0;
                char prev = 'F';
                for (int j = 0; j < n; j++) {
                    char c = s.charAt(j);
                    if (c == 'X') {
                        if (prev == 'O') {
                            temp = temp + lastO + 1;
                            if (temp >= p) temp -= p;
                        }
                        lastX = j;
                    } else if (c == 'O') {
                        if (prev == 'X') {
                            temp = temp + lastX + 1;
                            if (temp >= p) temp -= p;
                        }
                        lastO = j;
                    }
                    ans += temp;
                    if (ans >= p) ans -= p;
                    if (c != 'F') prev = c;
                }
                printer.println("Case #" + i + ": " + ans);
            }
        }
    }
}
