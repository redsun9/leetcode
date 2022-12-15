package advent.year2022.day15.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int y = 2000000;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day15/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day15/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<int[]> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
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
                int dx = dist - Math.abs(y - sy);
                if (dx >= 0) list.add(new int[]{sx - dx, sx + dx});
                if (by == y) set.add(bx);
                if (sy == y) set.add(sx);
            }

            int[] exclude = set.stream().sorted().mapToInt(x -> x).toArray();
            int[][] include = collapse(list).toArray(new int[0][]);
            int ans = 0, pos = 0, n = exclude.length;
            for (int[] segment : include) {
                int a = segment[0], b = segment[1];
                ans += b - a + 1;
                while (pos < n && exclude[pos] <= b) {
                    if (exclude[pos] >= a) ans--;
                    pos++;
                }
            }
            printer.println(ans);
        }
    }

    private static List<int[]> collapse(List<int[]> list) {
        list.sort(Comparator.comparingInt(x -> x[0]));
        List<int[]> ans = new ArrayList<>();
        int[] last = list.get(0);
        ans.add(last);
        for (int[] arr : list) {
            if (arr[0] <= last[1] + 1) last[1] = Math.max(last[1], arr[1]);
            else {
                last = arr;
                ans.add(last);
            }
        }
        return ans;
    }
}
