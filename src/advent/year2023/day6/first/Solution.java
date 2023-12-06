package advent.year2023.day6.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day6/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day6/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 1;
            String[] times = scanner.nextLine().trim().split(" +");
            String[] distances = scanner.nextLine().trim().split(" +");
            for (int i = 1; i < times.length; i++) ans *= solve(parseInt(times[i]), parseInt(distances[i]));
            printer.println(ans);
        }
    }

    // x*(t-x)>d => {s < n^2/4, (n - Sqrt[n^2 - 4 s])/2 < x < (n + Sqrt[n^2 - 4 s])/2}
    private static long solve(int time, int distance) {
        if (distance * 4 >= time * time) return 0L;
        double sqrt = Math.sqrt(time * time - 4 * distance);

        long min = (int) ((time - sqrt) / 2);
        if (min * (time - min) <= distance) min++;

        long max = (int) Math.round((sqrt + time) / 2);
        if (max * (time - max) <= distance) max--;

        return max - min + 1;
    }
}
