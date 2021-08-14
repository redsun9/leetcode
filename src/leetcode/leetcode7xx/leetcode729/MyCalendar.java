package leetcode.leetcode7xx.leetcode729;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    private final TreeMap<Integer, Integer> map = new TreeMap<>();

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floorEntry = map.floorEntry(end - 1);
        if (floorEntry != null && floorEntry.getValue() > start) return false;
        map.put(start, end);
        return true;
    }
}
