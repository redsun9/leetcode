package leetcode.leetcode1xx.leetcode146;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {
    private final LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    private final int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer remove = map.remove(key);
        if (remove == null) return -1;
        else map.put(key, remove);
        return remove;
    }

    public void put(int key, int value) {
        map.remove(key);
        if (map.size() == capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }
}
