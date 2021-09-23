package leetcode.leetcode2xx.leetcode253;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Interval> sq = new PriorityQueue<>(intervals.size(), Comparator.comparingInt(x -> x.start));
        PriorityQueue<Interval> eq = new PriorityQueue<>(intervals.size(), Comparator.comparingInt(x -> x.end));

        sq.addAll(intervals);
        eq.addAll(intervals);

        int ans = 0, curr = 0;
        while (!eq.isEmpty()) {
            int val = eq.peek().end;
            while (!sq.isEmpty() && sq.peek().start <= val) {
                curr++;
                sq.poll();
            }
            ans = Math.max(ans, curr);
            while (!eq.isEmpty() && eq.peek().end == val) {
                curr--;
                eq.poll();
            }
        }
        return ans;
    }
}
