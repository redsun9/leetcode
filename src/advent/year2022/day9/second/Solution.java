package advent.year2022.day9.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    private static final int k = 9;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day9/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day9/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            HashSet<Pair> set = new HashSet<>();
            int[][] pos = new int[k + 1][2];
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
                    pos[0][0] += dx;
                    pos[0][1] += dy;
                    for (int i = 0; i < k; i++) {
                        if (Math.abs(pos[i][0] - pos[i + 1][0]) == 2 || Math.abs(pos[i][1] - pos[i + 1][1]) == 2) {
                            pos[i + 1][0] += Math.signum(pos[i][0] - pos[i + 1][0]);
                            pos[i + 1][1] += Math.signum(pos[i][1] - pos[i + 1][1]);
                        }
                    }
                    set.add(new Pair(pos[k][0], pos[k][1]));
                }
            }
            printer.println(set.size());
        }
    }

    private record Pair(int x, int y) {
    }
}
