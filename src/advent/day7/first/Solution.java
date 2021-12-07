package advent.day7.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day7/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day7/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String[] split = scanner.nextLine().trim().split(",");
            int n = split.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(split[i]);
            Arrays.sort(arr);
            int mid = arr[n / 2];
            long ans = 0;
            for (int a : arr) ans += Math.abs(mid - a);
            printer.println(ans);
        }
    }
}
