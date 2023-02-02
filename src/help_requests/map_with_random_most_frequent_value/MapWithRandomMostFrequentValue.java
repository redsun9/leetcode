package help_requests.map_with_random_most_frequent_value;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MapWithRandomMostFrequentValue<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final Map<V, Integer> frequency = new HashMap<>();
    private final Map<Integer, SetWithRandom<V>> frequencyToValues = new HashMap<>();
    private int maxFrequency = 0;

    public V put(K key, V value) {
        if (value == null) return remove(key);
        V oldValue = map.put(key, value);
        if (value.equals(oldValue)) return value;
        if (oldValue != null) decFrequencies(oldValue);
        incFrequencies(value);
        return oldValue;
    }

    public V get(K key) {
        return map.get(key);
    }

    public V remove(K key) {
        V value = map.remove(key);
        if (value == null) return null;
        decFrequencies(value);
        return value;
    }

    public V getRandomValueWithMaxFrequency() {
        if (maxFrequency == 0) return null;
        return frequencyToValues.get(maxFrequency).getRandom();
    }

    public int getMaxFrequency() {
        return maxFrequency;
    }

    private void incFrequencies(V v) {
        int oldFrequency = frequency.getOrDefault(v, 0);
        int newFrequency = oldFrequency + 1;
        frequency.put(v, newFrequency);
        if (oldFrequency > 0) {
            frequencyToValues.get(oldFrequency).remove(v);
            if (frequencyToValues.get(oldFrequency).isEmpty()) frequencyToValues.remove(oldFrequency);
        }
        frequencyToValues.computeIfAbsent(newFrequency, f -> new SetWithRandom<>()).add(v);
        maxFrequency = Math.max(maxFrequency, newFrequency);
    }

    private void decFrequencies(V v) {
        int oldFrequency = frequency.get(v);
        int newFrequency = oldFrequency - 1;
        frequency.put(v, newFrequency);
        frequencyToValues.get(oldFrequency).remove(v);
        if (frequencyToValues.get(oldFrequency).isEmpty()) frequencyToValues.remove(oldFrequency);
        if (newFrequency > 0) {
            frequencyToValues.computeIfAbsent(newFrequency, f -> new SetWithRandom<>()).add(v);
        } else {
            frequency.remove(v);
        }
        if (!frequencyToValues.containsKey(maxFrequency)) maxFrequency--;
    }

    private static class SetWithRandom<V> {
        private final List<V> list = new ArrayList<>();
        private final Map<V, Integer> map = new HashMap<>();
        private final Random random = ThreadLocalRandom.current();

        public void add(V v) {
            if (map.containsKey(v)) return;
            map.put(v, list.size());
            list.add(v);
        }

        public void remove(V v) {
            if (!map.containsKey(v)) return;
            int index = map.get(v);
            map.remove(v);
            if (index == list.size() - 1) {
                list.remove(index);
                return;
            }
            V last = list.remove(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
        }

        private boolean isEmpty() {
            return list.isEmpty();
        }

        public V getRandom() {
            return list.get(random.nextInt(list.size()));
        }

    }
}
