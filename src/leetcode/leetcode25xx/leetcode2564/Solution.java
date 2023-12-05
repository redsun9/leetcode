package leetcode.leetcode25xx.leetcode2564;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int len = 1, key = 0, j = i; len <= 30 && j < n; len++, j++) {
                key = key << 1 | (s.charAt(j) - '0');
                int[] prev = map.get(key);
                if (prev == null || prev[1] - prev[0] + 1 > len) map.put(key, new int[]{i, j});
                if (key == 0) break;
            }
        }

        int m = queries.length;
        int[][] ans = new int[m][2];
        for (int i = 0; i < m; i++) {
            int key = queries[i][0] ^ queries[i][1];
            int[] val = map.get(key);
            if (val == null) {
                ans[i][0] = -1;
                ans[i][1] = -1;
            } else {
                ans[i][0] = val[0];
                ans[i][1] = val[1];
            }
        }
        return ans;
    }
}
