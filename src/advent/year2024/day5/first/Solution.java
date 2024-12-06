package advent.year2024.day5.first;

import basic.tuples.Pair;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day5/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day5/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Set<Pair<Integer, Integer>> set = new HashSet<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) break;
                String[] split = s.split("\\|");
                set.add(new Pair<>(parseInt(split[0]), parseInt(split[1])));
            }

            long ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) break;
                String[] split = s.split(",");
                int n = split.length;
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) arr[i] = parseInt(split[i]);
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (set.contains(new Pair<>(arr[j], arr[i]))) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok) ans += arr[n / 2];
            }

            printer.println(ans);
        }
    }
}
