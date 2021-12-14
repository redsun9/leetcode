package advent.day14.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class Solution3 {
    private static final int ALPHABET_SIZE = 26;
    private static final int STEPS = 40;

    private static final HashMap<Integer, Integer> pairToIndex = new HashMap<>();
    private static final List<int[]> usedPairs = new ArrayList<>();
    private static final List<Integer> pairsStart = new ArrayList<>();
    private static int usedPairsCount = 0;


    private static int getIndex(int pair) {
        Integer idx = pairToIndex.putIfAbsent(pair, usedPairsCount);
        if (idx == null) {
            idx = usedPairsCount++;
            usedPairs.add(new int[]{pair / ALPHABET_SIZE, pair % ALPHABET_SIZE});
            pairsStart.add(0);
        }
        return idx;
    }

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

            for (int i = 1; i < m; i++) {
                int a = start.charAt(i - 1) - 'A';
                int b = start.charAt(i) - 'A';
                int idx = getIndex(a * ALPHABET_SIZE + b);
                pairsStart.set(idx, pairsStart.get(idx) + 1);
            }

            scanner.nextLine();
            List<int[]> rules = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String split = scanner.nextLine();
                int a = split.charAt(0) - 'A';
                int b = split.charAt(1) - 'A';
                int c = split.charAt(6) - 'A';
                int from = getIndex(a * ALPHABET_SIZE + b);
                int to1 = getIndex(a * ALPHABET_SIZE + c);
                int to2 = getIndex(c * ALPHABET_SIZE + b);
                rules.add(new int[]{from, to1, to2});
            }
            long[][] mat = new long[usedPairsCount][usedPairsCount];
            for (int[] rule : rules) {
                mat[rule[1]][rule[0]]++;
                mat[rule[2]][rule[0]]++;
            }

            long[][] matrixPower = fastMatrixPower(mat, STEPS);
            long[] total = new long[ALPHABET_SIZE];
            total[start.charAt(0) - 'A'] = 1;
            total[start.charAt(m - 1) - 'A'] = 1;

            for (int i = 0; i < usedPairsCount; i++) {
                int a = usedPairs.get(i)[0];
                int b = usedPairs.get(i)[1];
                long[] mult = matrixPower[i];
                long sum = 0;
                for (int j = 0; j < usedPairsCount; j++) sum += pairsStart.get(j) * mult[j];
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
