package leetcode.leetcode17xx.leetcode1761;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Comparator.comparingInt;

@SuppressWarnings("unchecked")
public class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        Arrays.sort(edges, comparingInt(x -> max(x[0], x[1])));
        int[] count = new int[n];
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) list[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = min(edge[0], edge[1]) - 1, v = max(edge[0], edge[1]) - 1;
            count[u]++;
            count[v]++;
            list[u].add(v);
        }
        int ans = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            int tmp = count[u] + count[v];
            List<Integer> l1 = list[u], l2 = list[v];
            int n1 = l1.size(), n2 = l2.size();
            int i1 = 0, i2 = 0;
            while (i1 < n1 && i2 < n2) {
                int w1 = l1.get(i1), w2 = l2.get(i2);
                if (w1 == w2) ans = min(ans, tmp + count[w1]);
                if (w1 <= w2) i1++;
                if (w2 <= w1) i2++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans - 6;
    }
}
