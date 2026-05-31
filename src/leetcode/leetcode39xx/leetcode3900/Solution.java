package leetcode.leetcode39xx.leetcode3900;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestBalanced(String s) {
        int n = s.length(), cnt0 = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '0') cnt0++;
        int maxPossible = 2 * Math.min(cnt0, n - cnt0);
        if (maxPossible <= 2) return maxPossible;

        Map<Integer, Integer[]> map = new HashMap<>();
        map.put(0, new Integer[]{-1, null});
        int ans = 0;
        for (int i = 0, cnt = 0; i < n; i++) {
            cnt += s.charAt(i) == '0' ? 1 : -1;

            //check already balanced
            Integer[] prev = map.get(cnt);
            if (prev != null) {
                ans = Math.max(ans, i - prev[0]);
                if (prev[1] == null) prev[1] = i;
            } else {
                map.put(cnt, new Integer[]{i, null});
            }

            // check with extra zero
            prev = map.get(cnt - 2);
            if (prev != null) {
                if (i - prev[0] <= maxPossible) ans = Math.max(ans, i - prev[0]);
                if (prev[1] != null) ans = Math.max(ans, i - prev[1]);
            }

            // check with extra one
            prev = map.get(cnt + 2);
            if (prev != null) {
                if (i - prev[0] <= maxPossible) ans = Math.max(ans, i - prev[0]);
                if (prev[1] != null) ans = Math.max(ans, i - prev[1]);
            }
        }
        return ans;
    }
}
