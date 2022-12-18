package advent.year2022.day18.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.lang.Integer.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static final int[][] moves = {
            {0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}
    };

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day18/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day18/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<int[]> list = new ArrayList<>();
            int minX = MAX_VALUE, maxX = MIN_VALUE;
            int minY = MAX_VALUE, maxY = MIN_VALUE;
            int minZ = MAX_VALUE, maxZ = MIN_VALUE;
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().trim().split(",");
                int x = parseInt(split[0]);
                int y = parseInt(split[1]);
                int z = parseInt(split[2]);
                list.add(new int[]{x, y, z});
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
                minZ = Math.min(minZ, z);
                maxZ = Math.max(maxZ, z);
            }

            minX--;
            maxX++;
            minY--;
            maxY++;
            minZ--;
            maxZ++;
            int sx = maxX - minX, sy = maxY - minY, sz = maxZ - minZ;
            int[][][] f = new int[sx + 1][sy + 1][sz + 1];
            for (int[] p : list) f[p[0] - minX][p[1] - minY][p[2] - minZ] = 1;
            Deque<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i <= sx; i++) {
                for (int j = 0; j <= sy; j++) {
                    for (int k = 0; k <= sz; k++) {
                        if (i == 0 || i == sx || j == 0 || j == sy || k == 0 || k == sz) {
                            queue.add(new int[]{i, j, k});
                            f[i][j][k] = 2;
                        }
                    }
                }
            }
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                for (int[] move : moves) {
                    int x1 = poll[0] + move[0], y1 = poll[1] + move[1], z1 = poll[2] + move[2];
                    if (x1 < 0 || x1 > sx || y1 < 0 || y1 > sy || z1 < 0 || z1 > sz || f[x1][y1][z1] != 0) continue;
                    f[x1][y1][z1] = 2;
                    queue.add(new int[]{x1, y1, z1});
                }
            }

            int ans = 0;
            for (int[] point : list) {
                for (int[] move : moves) {
                    if (f[point[0] - minX + move[0]][point[1] - minY + move[1]][point[2] - minZ + move[2]] == 2) ans++;
                }
            }
            printer.println(ans);
        }
    }
}
