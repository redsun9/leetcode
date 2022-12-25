package advent.year2022.day25.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day25/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day25/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long sum = 0;
            while (scanner.hasNextLine()) sum += convertFromBalancedFive(scanner.nextLine().trim());
            printer.println(convertToBalancedFive(sum));
        }
    }

    private static long convertFromBalancedFive(String s) {
        long ans = 0, power = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += power * switch (s.charAt(i)) {
                case '2' -> 2;
                case '1' -> 1;
                case '0' -> 0;
                case '-' -> -1;
                default -> -2;
            };
            power *= 5L;
        }
        return ans;
    }

    private static String convertToBalancedFive(long num) {
        char[] ans = new char[50];
        int start = 50;
        while (num != 0) {
            int mod = (int) (num % 5);
            if (mod < 0) mod += 5;
            ans[--start] = switch (mod) {
                case 0 -> '0';
                case 1 -> '1';
                case 2 -> '2';
                case 3 -> '=';
                default -> '-';
            };
            if (mod >= 3) num += 5 - mod;
            num /= 5;
        }
        return new String(ans, start, 50 - start);
    }
}
