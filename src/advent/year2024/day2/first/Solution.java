package advent.year2024.day2.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day2/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day2/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                String[] parts = s.split(" +");
                int[] arr = new int[parts.length];
                for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i]);
                if (isSafe(arr)) ans++;
            }
            printer.println(ans);
        }
    }

    private static boolean isSafe(int[] arr) {
        if (arr.length <= 1) return true;
        if (arr[0] == arr[1]) return false;
        int signum = Integer.signum(arr[1] - arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 3 || Integer.signum(arr[i] - arr[i - 1]) != signum) return false;
        }
        return true;
    }
}
