package leetcode.leetcode22xx.leetcode2276;

import java.util.Map;
import java.util.TreeMap;

public class CountIntervals {
    private int count = 0;
    private final TreeMap<Integer, Integer> map = new TreeMap<>();

    public void add(int left, int right) {
        right++;
        Map.Entry<Integer, Integer> floorEntry = map.floorEntry(right);
        while (floorEntry != null && floorEntry.getValue() >= left) {
            map.remove(floorEntry.getKey());
            count -= floorEntry.getValue() - floorEntry.getKey();
            left = Math.min(left, floorEntry.getKey());
            right = Math.max(right, floorEntry.getValue());
            floorEntry = map.floorEntry(right);
        }
        map.put(left, right);
        count += right - left;
    }

    public int count() {
        return count;
    }
}
