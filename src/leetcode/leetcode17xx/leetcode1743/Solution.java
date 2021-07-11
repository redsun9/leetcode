package leetcode.leetcode17xx.leetcode1743;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            map.compute(pair[0], (k, v) -> {
                if (v == null) return new Pair(pair[1]);
                v.b = pair[1];
                return v;
            });
            map.compute(pair[1], (k, v) -> {
                if (v == null) return new Pair(pair[0]);
                v.b = pair[0];
                return v;
            });
        }
        int n = adjacentPairs.length;
        int[] ans = new int[n + 1];

        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            if (entry.getValue().b == null) {
                ans[0] = entry.getKey();
                ans[1] = entry.getValue().a;
            }
        }
        for (int i = 2; i <= n; i++) {
            Pair pair = map.get(ans[i - 1]);
            if (pair.a == ans[i - 2]) ans[i] = pair.b;
            else ans[i] = pair.a;
        }
        return ans;
    }

    private static class Pair {
        Integer a, b;

        public Pair(Integer a) {
            this.a = a;
        }
    }
}
