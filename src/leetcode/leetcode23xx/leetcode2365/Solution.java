package leetcode.leetcode23xx.leetcode2365;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long ans = 0;
        for (int task : tasks) {
            ans = Math.max(ans, map.getOrDefault(task, 0L)) + 1;
            map.put(task, ans + space);
        }
        return ans;
    }
}
