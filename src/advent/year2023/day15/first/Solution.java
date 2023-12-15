package advent.year2023.day15.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day15/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day15/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            String[] parts = scanner.nextLine().trim().split(",");
            for (String part : parts) ans += solve(part);
            printer.println(ans);
        }
    }

    private static int solve(String str) {
        int ans = 0, n = str.length();
        for (int i = 0; i < n; i++) ans = (ans + str.charAt(i)) * 17 % 256;
        return ans;
    }
}
