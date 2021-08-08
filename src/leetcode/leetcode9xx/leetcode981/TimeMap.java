package leetcode.leetcode9xx.leetcode981;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    private final TreeMap<Node, String> map = new TreeMap<>(
            Comparator.comparing((Node x) -> x.key).thenComparingInt(x -> x.timestamp)
    );

    public void set(String key, String value, int timestamp) {
        map.put(new Node(key, timestamp), value);
    }

    public String get(String key, int timestamp) {
        Map.Entry<Node, String> entry = map.floorEntry(new Node(key, timestamp));
        if (entry == null || !entry.getKey().key.equals(key)) return "";
        return entry.getValue();
    }

    private static class Node {
        final String key;
        final int timestamp;

        public Node(String key, int timestamp) {
            this.key = key;
            this.timestamp = timestamp;
        }
    }
}
