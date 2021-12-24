package tinkoff.advent14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent14/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent14/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            scanner.nextLine();
            boolean[][] arr = new boolean[n][26];
            for (int i = 0; i < m; i++) {
                String[] s = scanner.nextLine().trim().split(" ");
                int pos = Integer.parseInt(s[0]) - 1;
                int c = s[1].charAt(0) - 'A';
                arr[pos][c] = true;
            }

            char[] ans = new char[n];
            for (int i = 0; i < n; i++) {
                boolean[] a = arr[i];
                int l = 0, r = 25;
                while (l < r && a[r]) r--;
                while (l < r) {
                    while (l < r && a[l]) l++;
                    r--;
                    while (l < r && a[r]) r--;
                    if (l < r) l++;
                }
                ans[i] = (char) ('A' + l);
            }
            printer.println(new String(ans));
        }
    }
}
