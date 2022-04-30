package leetcode.leetcode22xx.leetcode2258;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final int MAX_VAL = 1_000_000_000;

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] fire = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fire[i][j] = 1;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], d = fire[x][y];
            for (int[] dir : moves) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 0 || fire[nx][ny] != 0) continue;
                fire[nx][ny] = d + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        int[][] person = new int[m][n];
        queue.offer(new int[]{0, 0});
        person[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], d = person[x][y];
            for (int[] dir : moves) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 0 || person[nx][ny] != 0) continue;
                person[nx][ny] = d + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        if (person[m - 1][n - 1] == 0) return -1;
        if (fire[m - 1][n - 1] == 0) return MAX_VAL;
        int lo = -1, hi = fire[m - 1][n - 1] - person[m - 1][n - 1];
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (canReach(person, fire, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private static boolean canReach(int[][] person, int[][] fire, int time) {
        int m = person.length, n = person[0].length;
        if (fire[0][0] <= 1 + time) return false;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        dist[0][0] = 1 + time;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], d = dist[x][y];
            for (int[] dir : moves) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || person[nx][ny] == 0 || dist[nx][ny] != 0) continue;
                if (nx == m - 1 && ny == n - 1) return fire[nx][ny] >= d + 1;
                if (d + 1 >= fire[nx][ny]) continue;
                dist[nx][ny] = d + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
        return false;
    }
}
