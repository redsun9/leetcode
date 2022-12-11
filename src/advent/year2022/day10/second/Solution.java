package advent.year2022.day10.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day10/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day10/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<int[]> ops = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().trim().split(" ");
                switch (parts[0]) {
                    case "noop" -> ops.add(new int[]{1, 0});
                    case "addx" -> ops.add(new int[]{2, Integer.parseInt(parts[1])});
                    default -> throw new IllegalArgumentException();
                }
            }
            long x = 1, cycle = 0;
            int pos = 0, n = ops.size();
            while (cycle <= 240) {
                if (ops.get(pos)[0] == 1) {
                    process(printer, x, cycle++);
                } else {
                    process(printer, x, cycle++);
                    process(printer, x, cycle++);
                    x += ops.get(pos)[1];
                }
                pos++;
                if (pos == n) pos = 0;
            }
        }
    }

    private static void process(PrintStream printer, long x, long cycle) {
        if (Math.abs(cycle % 40 - x) <= 1) printer.print("#");
        else printer.print(".");
        if (cycle % 40 == 39) printer.println();
    }
}
