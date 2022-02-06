package leetcode.leetcode21xx.leetcode2146;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Arrays::compare);
        List<List<Integer>> ans = new ArrayList<>(k);

        int m = grid.length, n = grid[0].length, minPrice = pricing[0], maxPrice = pricing[1];
        int x0 = start[0], y0 = start[1], x1, y1, d, price;
        int[] poll;
        pq.offer(new int[]{0, grid[x0][y0], x0, y0});
        grid[x0][y0] = 0;
        while (k > 0 && !pq.isEmpty()) {
            poll = pq.poll();
            d = poll[0] + 1;
            price = poll[1];
            x0 = poll[2];
            y0 = poll[3];

            if (price != 1 && price >= minPrice && price <= maxPrice) {
                ans.add(List.of(x0, y0));
                k--;
            }
            for (int r = 0; r < 4; r++) {
                x1 = x0 + moves[r];
                y1 = y0 + moves[r + 1];
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] != 0) {
                    pq.offer(new int[]{d, grid[x1][y1], x1, y1});
                    grid[x1][y1] = 0;
                }
            }

        }

        return ans;
    }
}
