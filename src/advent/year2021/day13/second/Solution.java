package advent.year2021.day13.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day13/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day13/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Set<Point> set = new HashSet<>();
            String[] split;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isEmpty()) break;
                split = s.split(",");
                set.add(new Point(
                        Integer.parseInt(split[0].trim()),
                        Integer.parseInt(split[1].trim())
                ));
            }

            while (scanner.hasNextLine()) {
                split = scanner.nextLine().trim().split("[= ]+");
                boolean byX = split[2].trim().charAt(0) == 'x';
                int val = Integer.parseInt(split[3].trim());

                Set<Point> nextSet = new HashSet<>();
                for (Point point : set) {
                    if (byX) {
                        if (point.x <= val) nextSet.add(point);
                        else nextSet.add(new Point(2 * val - point.x, point.y));
                    } else {
                        if (point.y < val) nextSet.add(point);
                        else nextSet.add(new Point(point.x, 2 * val - point.y));
                    }
                }
                set = nextSet;
            }

            int maxH = 0, maxW = 0;
            for (Point point : set) {
                maxW = Math.max(maxW, point.x);
                maxH = Math.max(maxH, point.y);
            }
            boolean[][] field = new boolean[maxH + 1][maxW + 1];
            for (Point point : set) field[point.y][point.x] = true;

            for (int i = 0; i <= maxH; i++) {
                for (int j = 0; j <= maxW; j++) {
                    printer.print(field[i][j] ? '#' : ' ');
                }
                printer.println();
            }
        }
    }


    private static class Point {
        final int x, y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
