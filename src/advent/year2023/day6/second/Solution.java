package advent.year2023.day6.second;

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
                FileInputStream fis = new FileInputStream("src/advent/year2023/day6/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day6/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long time = parseLong(scanner.nextLine().trim().replaceAll("[\\D]+", ""));
            long distance = parseLong(scanner.nextLine().trim().replaceAll("[\\D]+", ""));
            printer.println(solve(time, distance));
        }
    }

    // x*(t-x)>d => {s < n^2/4, (n - Sqrt[n^2 - 4 s])/2 < x < (n + Sqrt[n^2 - 4 s])/2}
    private static long solve(long time, long distance) {
        if (distance * 4 >= time * time) return 0L;
        double sqrt = Math.sqrt(time * time - 4 * distance);

        long min = (int) ((time - sqrt) / 2);
        if (min * (time - min) <= distance) min++;

        long max = (int) Math.round((sqrt + time) / 2);
        if (max * (time - max) <= distance) max--;

        return max - min + 1;
    }
}