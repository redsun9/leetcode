package leetcode.leetcode10xx.leetcode1042;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        List<Integer>[] edges = new List[n];
        for (int[] path : paths) {
            int u = path[0] - 1;
            int v = path[1] - 1;
            int max = Math.max(u, v);
            int min = Math.min(u, v);
            if (edges[max] == null) edges[max] = new LinkedList<>();
            edges[max].add(min);
        }
        for (int i = 0; i < n; i++) {
            if (edges[i] != null) {
                int used = 0;
                for (Integer a : edges[i]) used |= 1 << ans[a];
                for (int j = 1; j <= 4; j++) {
                    if ((used & (1 << j)) == 0) {
                        ans[i] = j;
                        break;
                    }
                }
            } else ans[i] = 1;
        }
        return ans;
    }
}
