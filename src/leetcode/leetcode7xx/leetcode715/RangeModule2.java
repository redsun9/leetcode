package leetcode.leetcode7xx.leetcode715;

import java.util.TreeMap;

public class RangeModule2 {
    private final TreeMap<Integer, Integer> map;

    public RangeModule2() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (left >= right) return;
        Integer start = map.floorKey(left);
        if (start == null) start = map.ceilingKey(left);
        while (start != null && start <= right) {
            int end = map.get(start);
            if (end >= left) {
                map.remove(start);
                if (start < left) left = start;
                if (end > right) right = end;
            }
            start = map.ceilingKey(end);
        }
        map.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer floor = map.floorKey(left);
        return floor != null && map.get(floor) >= right;
    }

    public void removeRange(int left, int right) {
        if (left >= right) return;
        Integer start = map.floorKey(left);
        if (start == null) start = map.ceilingKey(left);
        while (start != null && start < right) {
            int end = map.get(start);
            if (end >= left) {
                map.remove(start);
                if (start < left) map.put(start, left);
                if (end > right) map.put(right, end);
            }
            start = map.ceilingKey(end);
        }
    }
}
