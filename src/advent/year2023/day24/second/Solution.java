package advent.year2023.day24.second;

import org.apache.commons.math3.fraction.BigFraction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
//                FileInputStream fis = new FileInputStream("src/advent/year2023/day24/example.txt");
                FileInputStream fis = new FileInputStream("src/advent/year2023/day24/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day24/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(parseInput(scanner)));
        }
    }

    private static List<long[]> parseInput(Scanner scanner) {
        List<long[]> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (s.isBlank()) continue;
            String[] split = s.split("[, @]+");
            long[] arr = new long[6];
            for (int i = 0; i < 6; i++) arr[i] = Long.parseLong(split[i]);
            input.add(arr);
        }
        return input;
    }

    private static long solve(List<long[]> input) {
        int n = input.size();
        BigFraction[][] a = new BigFraction[2 * (n - 1)][6];
        BigFraction[] y = new BigFraction[2 * (n - 1)];

        for (int i = 1; i < n; i++) {
            a[2 * (i - 1)][0] = new BigFraction(-(input.get(0)[4] - input.get(i)[4]));
            a[2 * (i - 1)][1] = new BigFraction(input.get(0)[3] - input.get(i)[3]);
            a[2 * (i - 1)][3] = new BigFraction(input.get(0)[1] - input.get(i)[1]);
            a[2 * (i - 1)][4] = new BigFraction(-(input.get(0)[0] - input.get(i)[0]));
            a[2 * (i - 1)][2] = BigFraction.ZERO;
            a[2 * (i - 1)][5] = BigFraction.ZERO;
            y[2 * (i - 1)] = new BigFraction(input.get(0)[1]).multiply(input.get(0)[3])
                    .subtract(new BigFraction(input.get(i)[1]).multiply(input.get(i)[3]))
                    .subtract(new BigFraction(input.get(0)[0]).multiply(input.get(0)[4]))
                    .add(new BigFraction(input.get(i)[0]).multiply(input.get(i)[4]));

            a[2 * (i - 1) + 1][0] = new BigFraction(-(input.get(0)[5] - input.get(i)[5]));
            a[2 * (i - 1) + 1][2] = new BigFraction(input.get(0)[3] - input.get(i)[3]);
            a[2 * (i - 1) + 1][3] = new BigFraction(input.get(0)[2] - input.get(i)[2]);
            a[2 * (i - 1) + 1][5] = new BigFraction(-(input.get(0)[0] - input.get(i)[0]));
            a[2 * (i - 1) + 1][1] = BigFraction.ZERO;
            a[2 * (i - 1) + 1][4] = BigFraction.ZERO;
            y[2 * (i - 1) + 1] = new BigFraction(input.get(0)[2]).multiply(input.get(0)[3])
                    .subtract(new BigFraction(input.get(i)[2]).multiply(input.get(i)[3]))
                    .subtract(new BigFraction(input.get(0)[0]).multiply(input.get(0)[5]))
                    .add(new BigFraction(input.get(i)[0]).multiply(input.get(i)[5]));
        }
        BigFraction[] ans = solve(a, y);
        return ans[0].longValue() + ans[1].longValue() + ans[2].longValue();
    }

    // A = M*N, x = N*1, y = M*1
    private static BigFraction[] solve(BigFraction[][] a, BigFraction[] y) {
        int m = a.length, n = a[0].length;
        for (int i = 0; i < n; i++) {
            //find non zero in column
            int tmpI = i;
            while (tmpI < m && a[tmpI][i].equals(BigFraction.ZERO)) tmpI++;
            if (tmpI >= m) throw new RuntimeException("Rank is below");

            //swap i and tmpI row
            swap(a, i, tmpI);
            swap(y, i, tmpI);
            BigFraction aii = a[i][i];
            a[i][i] = BigFraction.ONE;
            for (int j = i + 1; j < n; j++) a[i][j] = a[i][j].divide(aii);
            y[i] = y[i].divide(aii);
            for (int k = i + 1; k < m; k++) {
                BigFraction multiplier = a[k][i];
                a[k][i] = BigFraction.ZERO;
                if (multiplier.equals(BigFraction.ZERO)) continue;
                for (int j = i + 1; j < n; j++) a[k][j] = a[k][j].subtract(a[i][j].multiply(multiplier));
                y[k] = y[k].subtract(y[i].multiply(multiplier));
            }
        }

        for (int i = n + 1; i < m; i++) {
            if (!y[i].equals(BigFraction.ZERO)) throw new RuntimeException("Rank is higher");
        }

        for (int i = n - 1; i > 0; i--) {
            for (int k = i - 1; k >= 0; k--) {
                y[k] = y[k].subtract(y[i].multiply(a[k][i]));
            }
        }
        return Arrays.copyOf(y, n);
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
