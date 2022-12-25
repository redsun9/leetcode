package advent.year2022.day23.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static int[][][] moves = {
            {{-1, 0}, {-1, -1}, {-1, 1}},
            {{1, 0}, {1, -1}, {1, 1}},
            {{0, -1}, {-1, -1}, {1, -1}},
            {{0, 1}, {-1, 1}, {1, 1}}
    };
    private static final boolean DEBUG = true;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day23/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day23/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Set<Point> set = readInput(scanner);

            if (DEBUG) {
                debugPrint(set);
                System.out.println();
            }

            int ans = 0;
            while (true) {
                Result result = processRound(set, ans++);
                set = result.set;
                if (DEBUG) {
                    debugPrint(set);
                    System.out.println();
                }
                if (!result.anyMoved) {
                    printer.println(ans);
                    break;
                }
            }
        }
    }

    private static Result processRound(Set<Point> set, int round) {
        HashMap<Point, Integer> cntMap = new HashMap<>();
        Set<Point> ans = new HashSet<>();
        for (Point elf : set) {
            boolean hasNeighbors = false;
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) continue;
                    if (set.contains(new Point(elf.x + dx, elf.y + dy))) {
                        hasNeighbors = true;
                    }
                }
            }

            if (!hasNeighbors) continue;

            int direction = round % 4;
            for (int i = 0; i < 4; i++) {
                Point toStep = new Point(elf.x + moves[direction][0][0], elf.y + moves[direction][0][1]);
                Point toCheck1 = new Point(elf.x + moves[direction][1][0], elf.y + moves[direction][1][1]);
                Point toCheck2 = new Point(elf.x + moves[direction][2][0], elf.y + moves[direction][2][1]);
                if (!set.contains(toStep) && !set.contains(toCheck1) && !set.contains(toCheck2)) {
                    cntMap.compute(toStep, (k, v) -> v != null ? v + 1 : 1);
                    break;
                }
                direction++;
                if (direction == 4) direction = 0;
            }
        }

        boolean anyMoved = false;

        for (Point elf : set) {
            boolean hasNeighbors = false;
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) continue;
                    if (set.contains(new Point(elf.x + dx, elf.y + dy))) {
                        hasNeighbors = true;
                    }
                }
            }

            if (!hasNeighbors) {
                ans.add(elf);
                continue;
            }

            int direction = round % 4;
            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                Point toStep = new Point(elf.x + moves[direction][0][0], elf.y + moves[direction][0][1]);
                Point toCheck1 = new Point(elf.x + moves[direction][1][0], elf.y + moves[direction][1][1]);
                Point toCheck2 = new Point(elf.x + moves[direction][2][0], elf.y + moves[direction][2][1]);
                if (!set.contains(toStep) && !set.contains(toCheck1) && !set.contains(toCheck2)) {
                    if (cntMap.get(toStep) == 1) {
                        ans.add(toStep);
                        moved = true;
                    }
                    break;
                }
                direction++;
                if (direction == 4) direction = 0;
            }
            if (!moved) ans.add(elf);
            anyMoved |= moved;
        }
        return new Result(ans, anyMoved);
    }

    private static Set<Point> readInput(Scanner scanner) {
        Set<Point> set = new HashSet<>();
        int i = 0;
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            for (int j = 0; j < s.length(); j++) if (s.charAt(j) == '#') set.add(new Point(i, j));
            i++;
        }
        return set;
    }

    private static void debugPrint(Set<Point> set) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (Point point : set) {
            minX = Math.min(minX, point.x);
            maxX = Math.max(maxX, point.x);
            minY = Math.min(minY, point.y);
            maxY = Math.max(maxY, point.y);
        }

        char[][] f = new char[maxX - minX + 1][maxY - minY + 1];
        for (char[] row : f) Arrays.fill(row, '.');
        for (Point point : set) f[point.x - minX][point.y - minY] = '#';
        for (char[] row : f) System.out.println(new String(row));
    }


    private record Point(int x, int y) {
    }

    private record Result(Set<Point> set, boolean anyMoved) {
    }
}
