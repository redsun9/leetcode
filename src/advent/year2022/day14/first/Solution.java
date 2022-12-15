package advent.year2022.day14.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int START_Y = 500;
    private static final int[] ORDER = {0, -1, 1};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day14/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day14/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Function<int[], BiFunction<Integer, List<int[]>, List<int[]>>> f = (arr) -> (key, prev) -> {
                if (prev == null) prev = new ArrayList<>();
                prev.add(arr);
                return prev;
            };

            HashMap<Integer, List<int[]>> xs = new HashMap<>();
            HashMap<Integer, List<int[]>> ys = new HashMap<>();

            int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
            int maxX = Integer.MIN_VALUE;


            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().trim().split("->");
                int n = parts.length;
                int[][] partCoords = new int[n][2];
                for (int i = 0; i < n; i++) {
                    String[] split = parts[i].trim().split(",");
                    partCoords[i][0] = Integer.parseInt(split[1]);
                    partCoords[i][1] = Integer.parseInt(split[0]);
                    maxX = Math.max(maxX, partCoords[i][0]);
                    minY = Math.min(minY, partCoords[i][1]);
                    maxY = Math.max(maxY, partCoords[i][1]);
                }
                for (int i = 1; i < n; i++) {
                    int[] a = partCoords[i - 1], b = partCoords[i];
                    if (a[0] == b[0]) xs.compute(a[0], f.apply(new int[]{Math.min(a[1], b[1]), Math.max(a[1], b[1])}));
                    else ys.compute(a[1], f.apply(new int[]{Math.min(a[0], b[0]), Math.max(a[0], b[0])}));
                }
            }
            ys.replaceAll((key, list) -> collapse(list));
            xs.replaceAll((key, list) -> collapse(list));

            minY--;
            maxY++;
            maxX++;
            int width = maxY - minY;

            // 0 - unprocessed, 1 - stone, 2 - falling, 3 - rest
            int[][] status = new int[maxX + 2][width + 1];

            for (Map.Entry<Integer, List<int[]>> entry : xs.entrySet()) {
                int i = entry.getKey();
                for (int[] segment : entry.getValue()) {
                    int startY = segment[0] - minY, endY = segment[1] - minY;
                    for (int j = startY; j <= endY; j++) status[i][j] = 1;
                }
            }
            for (Map.Entry<Integer, List<int[]>> entry : ys.entrySet()) {
                int j = entry.getKey() - minY;
                for (int[] segment : entry.getValue()) {
                    int startX = segment[0], endX = segment[1];
                    for (int i = startX; i <= endX; i++) status[i][j] = 1;
                }
            }

            Arrays.fill(status[status.length - 1], 2);
            for (int[] col : status) {
                col[0] = 2;
                col[col.length - 1] = 2;
            }

            ArrayDeque<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{0, START_Y - minY});
            int ans = 0;
            while (!queue.isEmpty()) {
                int[] peek = queue.peekLast();
                int x = peek[0], y = peek[1];
                boolean canBeProcessed = true;
                boolean falling = false;
                for (int dy : ORDER) {
                    if (status[x + 1][y + dy] == 0) {
                        canBeProcessed = false;
                        queue.addLast(new int[]{x + 1, y + dy});
                        break;
                    }
                    if (status[x + 1][y + dy] == 2) {
                        falling = true;
                        break;
                    }
                }
                if (canBeProcessed) {
                    queue.pollLast();
                    if (falling) {
                        status[x][y] = 2;
                    } else {
                        status[x][y] = 3;
                        ans++;
                    }
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
