package help_requests.map_with_random_key_for_value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class MapWithRandomKeyForValue<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final Map<V, SetWithRandom<K>> reverseMap = new HashMap<>();

    public V put(K key, V value) {
        if (value == null) return remove(key);
        V oldValue = map.put(key, value);
        if (value.equals(oldValue)) return value;
        if (oldValue != null) remove(key, oldValue);
        add(key, value);
        return oldValue;
    }

    public V get(K key) {
        return map.get(key);
    }

    public V remove(K key) {
        V value = map.remove(key);
        if (value == null) return null;
        remove(key, value);
        return value;
    }

    public K getRandomKeyForValue(V value) {
        SetWithRandom<K> keySetForValue = reverseMap.get(value);
        if (keySetForValue == null) return null;
        return keySetForValue.getRandom();
    }


    private void remove(K key, V value) {
        SetWithRandom<K> keySetForValue = reverseMap.get(value);
        keySetForValue.remove(key);
        if (keySetForValue.isEmpty()) reverseMap.remove(value);
    }

    private void add(K key, V value) {
        SetWithRandom<K> keySetForValue = reverseMap.computeIfAbsent(value, v -> new SetWithRandom<>());
        keySetForValue.add(key);
    }

    private static class SetWithRandom<T> {
        private final Map<T, Integer> map = new HashMap<>();
        private final List<T> list = new ArrayList<>();

        public void add(T t) {
            map.put(t, list.size());
            list.add(t);
        }

        public void remove(T t) {
            int index = map.remove(t);
            T last = list.remove(list.size() - 1);
            if (index < list.size()) {
                list.set(index, last);
                map.put(last, index);
            }
        }

        public T getRandom() {
            int index = ThreadLocalRandom.current().nextInt(list.size());
            return list.get(index);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
}
