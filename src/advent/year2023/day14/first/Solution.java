package advent.year2023.day14.first;

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
                FileInputStream fis = new FileInputStream("src/advent/year2023/day14/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day14/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (!s.isBlank()) list.add(s);
            }
            printer.println(solve(list));
        }
    }

    private static long solve(List<String> list) {
        int m = list.size(), n = list.get(0).length();
        int[] arr = new int[n];
        long ans = 0;
        for (int i = 0; i < m; i++) {
            String s = list.get(i);
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '#') arr[j] = i + 1;
                else if (s.charAt(j) == 'O') {
                    ans += n - arr[j];
                    arr[j]++;
                }
            }
        }
        return ans;
    }
}
