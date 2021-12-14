package advent.day14.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int ALPHABET_SIZE = 26;
    private static final int NUMBER_OF_PAIRS = ALPHABET_SIZE * ALPHABET_SIZE;
    private static final int STEPS = 40;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day14/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day14/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long startTime = System.currentTimeMillis();
            String start = scanner.nextLine().trim();
            int m = start.length();
            long[] row = new long[NUMBER_OF_PAIRS];
            for (int i = 1; i < m; i++) {
                int a = start.charAt(i - 1) - 'A';
                int b = start.charAt(i) - 'A';
                row[a * ALPHABET_SIZE + b]++;
            }

            long[][] mat = new long[NUMBER_OF_PAIRS][NUMBER_OF_PAIRS];
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().trim().split(" -> ");
                int a = split[0].charAt(0) - 'A';
                int b = split[0].charAt(1) - 'A';
                int c = split[1].charAt(0) - 'A';
                mat[a * ALPHABET_SIZE + c][a * ALPHABET_SIZE + b]++;
                mat[c * ALPHABET_SIZE + b][a * ALPHABET_SIZE + b]++;
            }
            long[][] matrixPower = matrixPower(mat, STEPS);

            long[] total = new long[ALPHABET_SIZE];
            total[start.charAt(0) - 'A'] = 1;
            total[start.charAt(m - 1) - 'A'] = 1;
            for (int pair = 0; pair < NUMBER_OF_PAIRS; pair++) {
                long[] mult = matrixPower[pair];
                long sum = 0;
                for (int i = 0; i < NUMBER_OF_PAIRS; i++) sum += row[i] * mult[i];
                total[pair / ALPHABET_SIZE] += sum;
                total[pair % ALPHABET_SIZE] += sum;
            }


            long min = Long.MAX_VALUE, max = 0;
            for (long a : total) {
                if (a == 0) continue;
                min = Math.min(min, a);
                max = Math.max(max, a);
            }

            printer.println((max - min) / 2);
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        }
    }

    private static long[][] matrixPower(long[][] base, long pow) {
        int n = base.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }
        while (pow != 0) {
            if ((pow & 1) != 0) {
                res = multiplyMatrix(res, base);
                --pow;
            } else {
                base = multiplyMatrix(base, base);
                pow >>= 1;
            }
        }
        return res;
    }

    private static long[][] multiplyMatrix(long[][] a, long[][] b) {
        int n = a.length;
        long[][] ans = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ans;
    }
}
