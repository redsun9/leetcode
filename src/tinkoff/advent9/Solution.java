package tinkoff.advent9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent9/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent9/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int n = Integer.parseInt(scanner.nextLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = scanner.nextInt() - 1;

            int ans = 0;
            for (int i = 0; i < n; i++) {
                int len = 0, curr = i, nxt;
                while (arr[curr] != -1) {
                    nxt = arr[curr];
                    arr[curr] = -1;
                    curr = nxt;
                    len++;
                }
                ans = Math.max(ans, len);
            }
            printer.println(ans);
        }
    }
}
