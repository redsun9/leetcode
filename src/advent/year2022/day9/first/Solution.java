package advent.year2022.day9.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day9/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day9/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            HashSet<Pair> set = new HashSet<>();
            int hx = 0, hy = 0, tdx = 0, tdy = 0;
            set.add(new Pair(0, 0));
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                int dx = 0, dy = 0;
                switch (s.charAt(0)) {
                    case 'R' -> dx = 1;
                    case 'L' -> dx = -1;
                    case 'U' -> dy = 1;
                    case 'D' -> dy = -1;
                }
                int n = Integer.parseUnsignedInt(s, 2, s.length(), 10);
                while (n-- != 0) {
                    hx += dx;
                    hy += dy;
                    tdx -= dx;
                    tdy -= dy;
                    if (Math.abs(tdx) == 2 || Math.abs(tdy) == 2) {
                        tdx -= Integer.signum(tdx);
                        tdy -= Integer.signum(tdy);
                    }
                    set.add(new Pair(hx + tdx, hy + tdy));
                }
            }
            printer.println(set.size());
        }
    }

    private record Pair(int x, int y) {
    }
}
