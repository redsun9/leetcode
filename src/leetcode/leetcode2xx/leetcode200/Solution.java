package leetcode.leetcode2xx.leetcode200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char[] row = grid[i];
                if (row[j] == '1') {
                    count++;
                    queue.add(new Pair(i, j));
                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        if (grid[pair.i][pair.j] == '1') {
                            grid[pair.i][pair.j] = '0';
                            if (pair.i > 0 && grid[pair.i - 1][pair.j] == '1')
                                queue.add(new Pair(pair.i - 1, pair.j));
                            if (pair.i < m - 1 && grid[pair.i + 1][pair.j] == '1')
                                queue.add(new Pair(pair.i + 1, pair.j));
                            if (pair.j > 0 && grid[pair.i][pair.j - 1] == '1')
                                queue.add(new Pair(pair.i, pair.j - 1));
                            if (pair.j < n - 1 && grid[pair.i][pair.j + 1] == '1')
                                queue.add(new Pair(pair.i, pair.j + 1));
                        }
                    }
                }
            }
        }
        return count;
    }

    private static class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
