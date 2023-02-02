package help_requests.map_with_random_key_of_most_frequent_value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class MapWithRandomKeyForMostFrequentValue<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final Map<V, SetWithRandom<K>> reverseMap = new HashMap<>();
    private final Map<Integer, SetWithRandom<SetWithRandom<K>>> countToKeys = new HashMap<>();
    private int maxFrequency = 0;

    public V put(K key, V value) {
        if (value == null) return remove(key);
        V oldValue = map.put(key, value);
        if (value.equals(oldValue)) return value;
        if (oldValue != null) decFrequency(key, oldValue);
        incFrequency(key, value);
        return oldValue;
    }

    public V get(K key) {
        return map.get(key);
    }

    public V remove(K key) {
        V value = map.remove(key);
        if (value == null) return null;
        decFrequency(key, value);
        return value;
    }

    public int getMaxFrequency() {
        return maxFrequency;
    }

    public K getRandomKeyWithMaxFrequency() {
        if (maxFrequency == 0) return null;
        return countToKeys.get(maxFrequency).getRandom().getRandom();
    }

    private void incFrequency(K key, V value) {
        SetWithRandom<K> keySetForValue = reverseMap.computeIfAbsent(value, v -> new SetWithRandom<>());
        int oldFrequency = keySetForValue.size();
        int newFrequency = oldFrequency + 1;

        keySetForValue.add(key);
        if (oldFrequency > 0) {
            countToKeys.get(oldFrequency).remove(keySetForValue);
            if (countToKeys.get(oldFrequency).isEmpty()) countToKeys.remove(oldFrequency);
        }
        countToKeys.computeIfAbsent(newFrequency, f -> new SetWithRandom<>()).add(keySetForValue);
        maxFrequency = Math.max(maxFrequency, newFrequency);
    }

    private void decFrequency(K key, V value) {
        SetWithRandom<K> keySetForValue = reverseMap.get(value);
        int oldFrequency = keySetForValue.size();
        int newFrequency = oldFrequency - 1;

        keySetForValue.remove(key);
        if (keySetForValue.isEmpty()) reverseMap.remove(value);

        countToKeys.get(oldFrequency).remove(keySetForValue);
        if (countToKeys.get(oldFrequency).isEmpty()) countToKeys.remove(oldFrequency);

        if (newFrequency > 0) countToKeys.computeIfAbsent(newFrequency, f -> new SetWithRandom<>()).add(keySetForValue);
        if (!countToKeys.containsKey(maxFrequency)) maxFrequency--;
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

        private int size() {
            return list.size();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
}
