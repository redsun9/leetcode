package leetcode.leetcode22xx.leetcode2244;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) map.compute(task, (k, v) -> v == null ? 1 : v + 1);
        int ans = 0;
        for (Integer value : map.values()) {
            if (value == 1) return -1;
            ans += (value + 2) / 3;
        }
        return ans;
    }
}
