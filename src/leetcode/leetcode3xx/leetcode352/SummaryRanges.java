package leetcode.leetcode3xx.leetcode352;

import java.util.Map;
import java.util.TreeMap;

public class SummaryRanges {
    private TreeMap<Integer, Segment> map;


    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Map.Entry<Integer, Segment> left = map.lowerEntry(val);
        Map.Entry<Integer, Segment> right = map.higherEntry(val);
        if (left != null && right != null && left.getValue().b + 1 == val && right.getKey() == val + 1) {
            left.getValue().b = right.getValue().b;
            map.remove(right.getKey());
        } else if (left != null && left.getValue().b + 1 >= val) {
            left.getValue().b = Math.max(left.getValue().b, val);
        } else if (right != null && right.getValue().a == val + 1) {
            map.remove(right.getKey());
            right.getValue().a = val;
            map.put(val, right.getValue());
        } else map.put(val, new Segment(val, val));
    }

    public int[][] getIntervals() {
        int[][] ans = new int[map.size()][2];
        int pos = 0;
        for (Segment segment : map.values()) {
            ans[pos][0] = segment.a;
            ans[pos++][1] = segment.b;
        }
        return ans;
    }

    private static class Segment {
        int a, b;

        Segment(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
