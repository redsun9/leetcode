package leetcode.leetcode6xx.leetcode675;

import java.util.*;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) pq.offer(new int[]{forest.get(i).get(j), i, j});
            }
        }
        int startX = 0, startY = 0, startKey = 0, endX, endY, endKey, ans = 0;
        int[] poll;
        boolean[] seen = new boolean[m * n];
        while (!pq.isEmpty()) {
            Arrays.fill(seen, false);
            poll = pq.poll();
            endX = poll[1];
            endY = poll[2];
            endKey = endX * n + endY;
            if (startKey != endKey) {
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{startX, startY, 0});
                seen[startX * n + startY] = true;
                boolean found = false;
                while (!found && !queue.isEmpty()) {
                    poll = queue.poll();
                    int x = poll[0], y = poll[1], dist = poll[2] + 1;
                    for (int k = 0; k < 4; k++) {
                        int x1 = x + moves[k], y1 = y + moves[k + 1], key = x1 * n + y1;
                        if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && forest.get(x1).get(y1) != 0 && !seen[key]) {
                            if (key == endKey) {
                                ans += dist;
                                found = true;
                                break;
                            }
                            seen[key] = true;
                            queue.add(new int[]{x1, y1, dist});
                        }
                    }
                }
                if (!found) return -1;
            }
            startX = endX;
            startY = endY;
            startKey = endKey;
        }
        return ans;
    }
}
