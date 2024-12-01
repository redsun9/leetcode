package advent.year2024.day1.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day1/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day1/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                String[] parts = s.split(" +");
                map1.compute(Integer.parseInt(parts[0]), (k, v) -> v == null ? 1 : v + 1);
                map2.compute(Integer.parseInt(parts[1]), (k, v) -> v == null ? 1 : v + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                ans += (long) entry.getKey() * entry.getValue() * map2.getOrDefault(entry.getKey(), 0);
            }
            printer.println(ans);
        }
    }
}
