package leetcode.leetcode7xx.leetcode732;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarThree {
    private final TreeMap<Integer, Integer> map = new TreeMap<>();

    public int book(int start, int end) {
        int ans = 0;
        map.compute(start, (k, v) -> v == null ? 1 : v + 1);
        map.compute(end, (k, v) -> v == null ? -1 : v - 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
