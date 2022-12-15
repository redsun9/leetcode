package advent.year2022.day15.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int MAX_COORD = 4000000;
    private static final long MULTIPLIER = 4000000;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day15/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day15/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<int[]> list = new ArrayList<>();
            Set<Point> set = new HashSet<>();

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                int pos1 = s.indexOf('='), pos2 = s.indexOf(',', pos1),
                        pos3 = s.indexOf('=', pos2), pos4 = s.indexOf(':', pos3),
                        pos5 = s.indexOf('=', pos4), pos6 = s.indexOf(',', pos5),
                        pos7 = s.indexOf('=', pos6);
                int sx = Integer.parseInt(s, pos1 + 1, pos2, 10);
                int sy = Integer.parseInt(s, pos3 + 1, pos4, 10);
                int bx = Integer.parseInt(s, pos5 + 1, pos6, 10);
                int by = Integer.parseInt(s, pos7 + 1, s.length(), 10);
                int dist = Math.abs(sx - bx) + Math.abs(sy - by);
                list.add(new int[]{sx, sy, dist});
                set.add(new Point(sx, sy));
                set.add(new Point(bx, by));
            }

            list.sort(Comparator.comparingInt(x -> x[1]));

            long ans = 0;

            for (int x = 0; x <= MAX_COORD; x++) {
                int y = 0;
                for (int[] s : list) {
                    while (set.contains(new Point(x, y))) y++;
                    if (s[2] >= Math.abs(s[0] - x) + Math.abs(s[1] - y)) y = s[1] + s[2] - Math.abs(s[0] - x) + 1;
                }
                if (y <= MAX_COORD) {
                    ans = MULTIPLIER * x + y;
                    break;
                }
            }

            printer.println(ans);
        }
    }

    private record Point(int x, int y) {
    }
}
