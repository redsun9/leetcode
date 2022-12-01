package advent.year2021.day3.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day3/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day3/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int[] count = null;
            int m = 0, n = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (n == 0) {
                    m = s.length();
                    count = new int[m];
                }
                for (int i = 0; i < m; i++) count[i] += s.charAt(i) - '0';
                n++;
            }

            int gamma = 0;
            for (int i = 0; i < m; i++) {
                if (count[i] >= n / 2) gamma |= 1 << (m - 1 - i);
            }
            int epsilon = ((1 << m) - 1) ^ gamma;
            printer.println(gamma * epsilon);
        }
    }
}
