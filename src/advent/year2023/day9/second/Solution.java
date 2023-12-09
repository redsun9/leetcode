package advent.year2023.day9.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.Long.parseLong;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day9/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day9/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().trim().split(" +");
                int n = split.length;
                long[] nums = new long[n];
                for (int i = 0; i < n; i++) nums[i] = parseLong(split[i]);
                ans += solve(nums);
            }
            printer.println(ans);
        }
    }

    private static long solve(long[] nums) {
        boolean allZeros = true;
        for (long num : nums) {
            if (num != 0) {
                allZeros = false;
                break;
            }
        }
        if (allZeros) return 0L;

        int n = nums.length;
        long[] tmp = new long[n - 1];
        for (int i = 1; i < n; i++) tmp[i - 1] = nums[i] - nums[i - 1];
        return nums[0] - solve(tmp);
    }
}