package help_requests.map_with_all_unique;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("DataFlowIssue")
public class MapWithAllUnique<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final Map<V, Integer> countMap = new HashMap<>();

    public V put(K key, V value) {
        if (value == null) return remove(key);
        V oldValue = map.put(key, value);
        if (value.equals(oldValue)) return oldValue;
        if (oldValue != null) countMap.compute(oldValue, (k, v) -> v == 1 ? null : v - 1);
        countMap.compute(value, (k, v) -> v == null ? 1 : v + 1);
        return oldValue;
    }

    public V get(K key) {
        return map.get(key);
    }

    public V remove(K key) {
        V oldValue = map.remove(key);
        if (oldValue != null) countMap.compute(oldValue, (k, v) -> v == 1 ? null : v - 1);
        return oldValue;
    }

    public boolean hasDuplicateValues() {
        return map.size() != countMap.size();
    }
}
