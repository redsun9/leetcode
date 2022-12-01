package advent.year2021.day14.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution2 {
    private static final int ALPHABET_SIZE = 26;
    private static final int MAX_NUMBER_OF_PAIRS = ALPHABET_SIZE * ALPHABET_SIZE;
    private static final int STEPS = 40;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day14/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day14/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long startTime = System.currentTimeMillis();
            String start = scanner.nextLine().trim();
            int m = start.length();
            long[] tmpRow = new long[MAX_NUMBER_OF_PAIRS];
            boolean[] isUsed = new boolean[MAX_NUMBER_OF_PAIRS];
            int usedPairsCount = 0;
            for (int i = 1; i < m; i++) {
                int a = start.charAt(i - 1) - 'A';
                int b = start.charAt(i) - 'A';
                int pair = a * ALPHABET_SIZE + b;
                isUsed[pair] = true;
                if (tmpRow[pair]++ == 0) usedPairsCount++;
            }

            int[][] tmpMat = new int[MAX_NUMBER_OF_PAIRS][MAX_NUMBER_OF_PAIRS];
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String split = scanner.nextLine();
                int a = split.charAt(0) - 'A';
                int b = split.charAt(1) - 'A';
                int c = split.charAt(6) - 'A';
                int from = a * ALPHABET_SIZE + b;
                int to1 = a * ALPHABET_SIZE + c;
                int to2 = c * ALPHABET_SIZE + b;

                if (!isUsed[from]) {
                    isUsed[from] = true;
                    usedPairsCount++;
                }
                if (!isUsed[to1]) {
                    isUsed[to1] = true;
                    usedPairsCount++;
                }
                if (!isUsed[to2]) {
                    isUsed[to2] = true;
                    usedPairsCount++;
                }

                tmpMat[to1][from]++;
                tmpMat[to2][from]++;
            }

            int[] usedPairs = new int[usedPairsCount];
            for (int i = 0, pos = 0; pos < usedPairsCount; i++) {
                if (isUsed[i]) usedPairs[pos++] = i;
            }

            long[][] mat = new long[usedPairsCount][usedPairsCount];
            long[] row = new long[usedPairsCount];
            for (int i = 0; i < usedPairsCount; i++) {
                int usedPair = usedPairs[i];
                int[] tmpMatRow = tmpMat[usedPair];
                long[] matRow = mat[i];
                row[i] = tmpRow[usedPair];
                for (int j = 0; j < usedPairsCount; j++) matRow[j] = tmpMatRow[usedPairs[j]];
            }

            long[][] matrixPower = fastMatrixPower(mat, STEPS);
            long[] total = new long[ALPHABET_SIZE];
            total[start.charAt(0) - 'A'] = 1;
            total[start.charAt(m - 1) - 'A'] = 1;

            for (int i = 0; i < usedPairsCount; i++) {
                int a = usedPairs[i] / ALPHABET_SIZE;
                int b = usedPairs[i] % ALPHABET_SIZE;
                long[] mult = matrixPower[i];
                long sum = 0;
                for (int j = 0; j < usedPairsCount; j++) sum += row[j] * mult[j];
                total[a] += sum;
                total[b] += sum;
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

    private static long[][] fastMatrixPower(long[][] base, long pow) {
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
