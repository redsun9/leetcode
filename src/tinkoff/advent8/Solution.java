package tinkoff.advent8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final char[] start = {
            ' ',
            ' ', 'A', 'D',
            'G', 'J', 'M',
            'P', 'T', 'W'
    };
    private static final int[] maxPress = {
            0,
            0, 3, 3,
            3, 3, 3,
            4, 3, 4
    };

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent8/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent8/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            char[] s = scanner.nextLine().trim().toCharArray();
            int n = s.length;
            char[] ans = new char[n];
            int ansLength = 0;
            for (int i = 0, left = 0; i < n; i++) {
                if (i == n - 1 || s[left] != s[i + 1]) {
                    int d = s[left] - '0';
                    int k = i - left + 1;
                    if (k % maxPress[d] != 0) ans[ansLength++] = (char) (start[d] + k % maxPress[d] - 1);
                    Arrays.fill(ans, ansLength, ansLength + k / maxPress[d], (char) (start[d] + maxPress[d] - 1));
                    ansLength += k / maxPress[d];
                    left = i + 1;
                }
            }
            printer.println(new String(ans, 0, ansLength));
        }
    }
}
