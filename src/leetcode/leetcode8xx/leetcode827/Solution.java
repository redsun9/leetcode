package leetcode.leetcode8xx.leetcode827;

import java.util.*;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        ArrayList<Integer> list = new ArrayList<>();
        int islandIndex = 2;
        Queue<int[]> queue = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    grid[i][j] = islandIndex;
                    int size = 1;
                    while (!queue.isEmpty()) {
                        int[] node = queue.poll();
                        int x1 = node[0], y1 = node[1];
                        for (int k = 0; k < 4; k++) {
                            int x2 = x1 + moves[k], y2 = y1 + moves[k + 1];
                            if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < n && grid[x2][y2] == 1) {
                                queue.add(new int[]{x2, y2});
                                size++;
                                grid[x2][y2] = islandIndex;
                            }
                        }
                    }
                    list.add(size);
                    ans = Math.max(ans, size);
                    islandIndex++;
                }
            }
        }
        if (ans == 0) return 1;
        if (islandIndex == 3) return Math.min(n * n, ans + 1);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) continue;
                for (int k = 0; k < 4; k++) {
                    int x2 = i + moves[k], y2 = j + moves[k + 1];
                    if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < n && grid[x2][y2] != 0) set.add(grid[x2][y2]);
                }
                if (!set.isEmpty()) {
                    int tmp = 1;
                    for (Integer index : set) tmp += list.get(index - 2);
                    ans = Math.max(ans, tmp);
                    set.clear();
                }
            }
        }
        return ans;
    }
}
