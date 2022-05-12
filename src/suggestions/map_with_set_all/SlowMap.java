package suggestions.map_with_set_all;

import java.util.HashMap;
import java.util.Map;

public class SlowMap<K, V> implements MapSetAll<K, V> {
    private final Map<K, V> map = new HashMap<>();

    public V get(K key) {
        return map.get(key);
    }

    public V put(K key, V value) {
        return map.put(key, value);
    }

    public V remove(K key) {
        return map.remove(key);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void clear() {
        map.clear();
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public void setAll(V value) {
        map.replaceAll((k, v) -> value);
    }
}
