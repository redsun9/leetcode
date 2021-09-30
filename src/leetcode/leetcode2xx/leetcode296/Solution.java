package leetcode.leetcode2xx.leetcode296;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> h = new ArrayList<>();
        List<Integer> w = new ArrayList<>();

        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            int[] row = grid[i];
            for (int val : row) {
                if (val == 1) h.add(i);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int[] ints : grid) {
                if (ints[j] == 1) w.add(j);
            }
        }
        int ans = 0;
        int total = h.size();
        int mid = total / 2;

        for (int i = 0; i < mid; i++) ans -= h.get(i) + w.get(i);
        for (int i = mid + 1; i < total; i++) ans += h.get(i) + w.get(i);
        if ((total & 1) == 0) ans += h.get(mid) + (int) w.get(mid);
        return ans;
    }
}
