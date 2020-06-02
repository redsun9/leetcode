package leetcode.leetcode12xx.leetcode1210;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Solution {
    public static final int[][] moves = {{0, 1, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 0, 1, -1, 1}, {0, 0, -1, 1, 1}};
    public static final boolean[][] allow = {{true, true}, {true, true}, {true, false}, {false, true}};

    private static int encode(int tx, int ty, int hx, int hy, int direction) {
        return tx | (ty << 7) | (hx << 14) | (hy << 21) | (direction << 28);
    }

    private static int[] decode(int key) {
        int[] ans = new int[5];
        for (int i = 0; i < 5; i++) {
            ans[i] = (key >>> (i * 7)) & 127;
        }
        return ans;
    }

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int start = encode(0, 0, 0, 1, 0);
        queue.add(start);
        map.put(start, 0);

        int ans = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Integer key = queue.poll();
            int[] curr = decode(key);
            int tx = curr[0]; //tail x- co-ordinate
            int ty = curr[1]; //tail y- co-ordinate
            int hx = curr[2]; //head x- co-ordinate
            int hy = curr[3]; //head y- co-ordinate
            int dir = curr[4];
            int curVal = map.get(key);
            if (tx == n - 1 && ty == n - 2 && hx == n - 1 && hy == n - 1) ans = Math.min(ans, curVal);
            for (int i = 0; i < moves.length; i++) {
                if (allow[i][dir]) {
                    int[] move = moves[i];
                    int ntx = tx + move[0]; // next tail x- co-ordinate
                    int nty = ty + move[1]; // next tail y- co-ordinate
                    int nhx = hx + move[2]; // next head x- co-ordinate
                    int nhy = hy + move[3]; // next head y- co-ordinate
                    int ndir = dir ^ move[4];
                    if (
                            nhx >= n || nhy >= n ||
                                    grid[nhx][nhy] == 1 ||
                                    grid[ntx][nty] == 1 ||
                                    (i == 2 && grid[nhx][nhy + 1] == 1) ||
                                    (i == 3 && grid[nhx + 1][nhy] == 1)
                    ) continue;
                    int nkey = encode(ntx, nty, nhx, nhy, ndir);
                    if (map.containsKey(nkey) && map.get(nkey) <= curVal + 1) continue;
                    map.put(nkey, curVal + 1);
                    queue.offer(nkey);
                }
            }
        }

        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
