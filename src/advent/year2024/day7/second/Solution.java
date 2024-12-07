package advent.year2024.day7.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day7/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day7/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            BigInteger ans = BigInteger.ZERO;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) continue;
                String[] split = s.split("[: ]+");
                BigInteger[] arr = new BigInteger[split.length];
                for (int i = 0; i < arr.length; i++) arr[i] = new BigInteger(split[i]);
                if (solve(arr)) ans = ans.add(arr[0]);
            }
            printer.println(ans);
        }
    }

    private static boolean solve(BigInteger[] arr) {
        return solve(arr, arr[1], 2, arr.length);
    }

    private static boolean solve(BigInteger[] arr, BigInteger curr, int i, int n) {
        if (i == n) return arr[0].equals(curr);
        return solve(arr, curr.add(arr[i]), i + 1, n) || solve(arr, curr.multiply(arr[i]), i + 1, n) ||
                solve(arr, new BigInteger(curr + arr[i].toString()), i + 1, n);
    }
}
