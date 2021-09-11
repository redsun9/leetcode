package facebook.hacker2021.round1.ProblemA1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2021/round1/ProblemA1/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2021/round1/ProblemA1/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= t; i++) {
                int n = Integer.parseInt(scanner.nextLine());
                int ans = 0;
                String s = scanner.nextLine();
                char prev = ' ';
                for (int j = 0; j < n; j++) {
                    char c = s.charAt(j);
                    if (c == 'X' && prev == 'O') ans++;
                    if (c == 'O' && prev == 'X') ans++;
                    if (c != 'F') prev = c;
                }
                printer.println("Case #" + i + ": " + ans);
            }
        }
    }
}
