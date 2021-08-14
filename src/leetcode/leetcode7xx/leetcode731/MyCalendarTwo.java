package leetcode.leetcode7xx.leetcode731;

import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("ConstantConditions")
public class MyCalendarTwo {
    private final TreeMap<Integer, Integer> map = new TreeMap<>();

    public boolean book(int start, int end) {
        map.compute(start, (k, v) -> v == null ? 1 : v + 1);
        map.compute(end, (k, v) -> v == null ? -1 : v - 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if (count > 2) {
                map.compute(start, (k, v) -> v == 1 ? null : v - 1);
                map.compute(end, (k, v) -> v == -1 ? null : v + 1);
                return false;
            }
        }
        return true;
    }
}
