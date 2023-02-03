package help_requests.map_with_delete_all_keys_for_value;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapWithDeleteAllKeyForValue2<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final Map<V, Set<K>> valuesToKeys = new HashMap<>();

    public V put(K key, V value) {
        if (value == null) return remove(key);
        V oldValue = map.put(key, value);
        if (value.equals(oldValue)) return oldValue;
        if (oldValue != null) {
            valuesToKeys.get(oldValue).remove(key);
            if (valuesToKeys.get(oldValue).isEmpty()) valuesToKeys.remove(oldValue);
        }
        valuesToKeys.computeIfAbsent(value, k -> new HashSet<>()).add(key);
        return oldValue;
    }

    public V get(K key) {
        return map.get(key);
    }

    public V remove(K key) {
        V oldValue = map.remove(key);
        if (oldValue == null) return null;
        valuesToKeys.get(oldValue).remove(key);
        if (valuesToKeys.get(oldValue).isEmpty()) valuesToKeys.remove(oldValue);
        return oldValue;
    }

    public void deleteAllKeysForValue(V value) {
        Set<K> keys = valuesToKeys.remove(value);
        if (keys != null) keys.forEach(map::remove);
    }
}
