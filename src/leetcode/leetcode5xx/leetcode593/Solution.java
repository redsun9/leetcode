package leetcode.leetcode5xx.leetcode593;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] p = {p1, p2, p3, p4};
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                int a = p[i][0] - p[j][0], b = p[i][1] - p[j][1];
                map.compute(a * a + b * b, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        boolean ans = true;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                if (entry.getKey() % 2 != 0 || map.getOrDefault(entry.getKey() / 2, 0) != 4) ans = false;
            } else if (entry.getValue() == 4) {
                if (map.getOrDefault(entry.getKey() * 2, 0) != 2) ans = false;
            } else ans = false;
        }
        return ans;
    }
}
