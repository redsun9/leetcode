package leetcode.leetcode2xx.leetcode252;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(interval.start);
            if (floorEntry != null && floorEntry.getValue() > interval.start) return false;
            Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(interval.start);
            if (ceilingEntry != null && ceilingEntry.getKey() < interval.end) return false;
            map.put(interval.start, interval.end);
        }
        return true;
    }
}
