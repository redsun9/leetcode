package leetcode.leetcode12xx.leetcode1263;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution {
    private static final int[][] moves = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int minPushBox(char[][] grid) {
        int[] box = null, target = null, storekeeper = null;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') box = new int[]{i, j};
                else if (grid[i][j] == 'T') target = new int[]{i, j};
                else if (grid[i][j] == 'S') storekeeper = new int[]{i, j};
            }
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int start = encode(box[0], box[1], storekeeper[0], storekeeper[1]);
        map.put(start, 0);
        q.offer(start);
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int prevKey = q.poll();
            int prevDist = map.get(prevKey);
            if (prevDist >= ans) continue;
            int[] c = decode(prevKey);
            if (c[0] == target[0] && c[1] == target[1]) {
                ans = Math.min(ans, prevDist);
                continue;
            }
            for (int[] move : moves) {
                int nsx = c[2] + move[0];
                int nsy = c[3] + move[1];
                if (nsx < 0 || nsx >= m || nsy < 0 || nsy >= n || grid[nsx][nsy] == '#') continue;
                if (nsx == c[0] && nsy == c[1]) {
                    int nbx = c[0] + move[0];
                    int nby = c[1] + move[1];
                    if (nbx < 0 || nbx >= m || nby < 0 || nby >= n || grid[nbx][nby] == '#') continue;
                    int nkey = encode(nbx, nby, nsx, nsy);
                    if (map.containsKey(nkey) && map.get(nkey) <= prevDist + 1) continue;
                    map.put(nkey, prevDist + 1);
                    q.offer(nkey);
                } else {
                    int nkey = encode(c[0], c[1], nsx, nsy);
                    if (map.containsKey(nkey) && map.get(nkey) <= prevDist) continue;
                    map.put(nkey, prevDist);
                    q.offer(nkey);
                }
            }
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    private static int encode(int bx, int by, int sx, int sy) {
        return (bx << 24) | (by << 16) | (sx << 8) | sy;
    }

    private static int[] decode(int num) {
        int[] ret = new int[4];
        ret[0] = (num >>> 24) & 0xff;
        ret[1] = (num >>> 16) & 0xff;
        ret[2] = (num >>> 8) & 0xff;
        ret[3] = num & 0xff;
        return ret;
    }
}
