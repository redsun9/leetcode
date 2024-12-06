package advent.year2024.day4.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day4/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day4/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> strings = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (!s.isBlank() && !s.isEmpty()) strings.add(s);
            }
            printer.println(solve(strings));
        }
    }

    private static int solve(List<String> arr) {
        int m = arr.size();
        int n = arr.get(0).length();
        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (
                        arr.get(i).charAt(j) == 'A' && (
                                arr.get(i - 1).charAt(j - 1) == 'M' && arr.get(i + 1).charAt(j + 1) == 'S' ||
                                        arr.get(i + 1).charAt(j + 1) == 'M' && arr.get(i - 1).charAt(j - 1) == 'S'
                        ) && (
                                arr.get(i + 1).charAt(j - 1) == 'M' && arr.get(i - 1).charAt(j + 1) == 'S' ||
                                        arr.get(i - 1).charAt(j + 1) == 'M' && arr.get(i + 1).charAt(j - 1) == 'S'
                        )
                ) ans++;
            }
        }
        return ans;
    }
}
