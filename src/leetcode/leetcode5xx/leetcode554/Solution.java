package leetcode.leetcode5xx.leetcode554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Long, Integer> map = new HashMap<>();
        long w = 0;
        for (List<Integer> list : wall) {
            long pos = 0;
            for (Integer a : list) {
                pos += a;
                map.compute(pos, (k, v) -> v == null ? 1 : v + 1);
            }
            w = pos;
        }
        int ans = 0;
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getKey() != w) ans = Math.max(ans, entry.getValue());
        }
        return wall.size() - ans;
    }
}
