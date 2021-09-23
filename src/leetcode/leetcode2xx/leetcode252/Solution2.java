package leetcode.leetcode2xx.leetcode252;

import java.util.Comparator;
import java.util.List;

public class Solution2 {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(x -> x.start));
        int end = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (end > interval.start) return false;
            end = interval.end;
        }
        return true;
    }
}
