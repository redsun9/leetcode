package suggestions.map_with_set_all;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FastMap2<K, V> implements MapSetAll<K, V> {
    private Map<K, V> map = new HashMap<>();
    private final Set<K> set = new HashSet<>();
    private V lastSetAllValue = null;

    @Override
    public V put(K key, V value) {
        if (value == null) return remove(key);
        if (set.contains(key)) {
            V oldValue = map.get(key);
            if (oldValue == null) oldValue = lastSetAllValue;
            map.put(key, value);
            return oldValue;
        } else {
            map.put(key, value);
            set.add(key);
            return null;
        }
    }

    @Override
    public V get(K key) {
        if (set.contains(key)) {
            V value = map.get(key);
            if (value == null) return lastSetAllValue;
            else return value;
        } else return null;
    }

    @Override
    public V remove(K key) {
        if (set.contains(key)) {
            V oldValue = map.remove(key);
            if (oldValue == null) oldValue = lastSetAllValue;
            set.remove(key);
            return oldValue;
        } else return null;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public void clear() {
        map.clear();
        set.clear();
    }

    @Override
    public boolean containsKey(K key) {
        return set.contains(key);
    }

    @Override
    public void setAll(V value) {
        lastSetAllValue = value;
        map = new HashMap<>();
    }
}
