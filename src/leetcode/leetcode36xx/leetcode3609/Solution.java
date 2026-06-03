package leetcode.leetcode36xx.leetcode3609;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int minMoves(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) return -1;
        if (sx == tx && sy == ty) return 0;
        Set<Pair> set = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{tx, ty, 1});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], d = poll[2];
            if (x % 2 == 0 && x >= 2 * y) {
                if (sx == x / 2 && sy == y) return d;
                if (set.add(new Pair(x / 2, y))) queue.offer(new int[]{x / 2, y, d + 1});
            }
            if (2 * x >= y && y >= x) {
                if (sx == x && sy == y - x) return d;
                if (set.add(new Pair(x, y - x))) queue.offer(new int[]{x, y - x, d + 1});
            }
            if (y % 2 == 0 && y >= 2 * x) {
                if (sy == y / 2 && sx == x) return d;
                if (set.add(new Pair(x, y / 2))) queue.offer(new int[]{x, y / 2, d + 1});
            }
            if (2 * y >= x && x >= y) {
                if (sx == x - y && sy == y) return d;
                if (set.add(new Pair(x - y, y))) queue.offer(new int[]{x - y, y, d + 1});
            }
        }
        return -1;
    }

    private record Pair(int x, int y) {
    }
}
