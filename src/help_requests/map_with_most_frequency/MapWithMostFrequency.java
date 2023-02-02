package help_requests.map_with_most_frequency;

import java.util.HashMap;
import java.util.Map;

public class MapWithMostFrequency<K, V> {
    private final Map<K, V> keyValueMap = new HashMap<>();
    private final Map<V, Integer> valueCountMap = new HashMap<>();
    private final Map<Integer, Integer> countNumberValuesMap = new HashMap<>();
    private int maxFrequency = 0;

    public V put(K key, V value) {
        if (value == null) return remove(key);
        V oldValue = keyValueMap.put(key, value);
        if (oldValue != null) removeValue(oldValue);
        addValue(value);
        return oldValue;
    }

    public V get(K key) {
        return keyValueMap.get(key);
    }

    public V remove(K key) {
        V oldValue = keyValueMap.remove(key);
        if (oldValue != null) removeValue(oldValue);
        return oldValue;
    }

    public int getMaxFrequency() {
        return maxFrequency;
    }

    private void addValue(V value) {
        int prevCount = valueCountMap.getOrDefault(value, 0);
        valueCountMap.compute(value, (k, v) -> v == null ? 1 : v + 1);
        if (prevCount != 0) countNumberValuesMap.compute(prevCount, (k, v) -> v == 1 ? null : v - 1);
        countNumberValuesMap.compute(prevCount + 1, (k, v) -> v == null ? 1 : v + 1);
        maxFrequency = Math.max(maxFrequency, prevCount + 1);
    }

    private void removeValue(V value) {
        int prevCount = valueCountMap.get(value);
        valueCountMap.compute(value, (k, v) -> v == 1 ? null : v - 1);
        countNumberValuesMap.compute(prevCount, (k, v) -> v == 1 ? null : v - 1);
        if (prevCount != 1) countNumberValuesMap.compute(prevCount - 1, (k, v) -> v == null ? 1 : v + 1);
        if (countNumberValuesMap.getOrDefault(maxFrequency, 0) == 0) maxFrequency--;
    }
}
