package help_requests.map_with_delete_all_keys_for_value;

import java.util.HashMap;
import java.util.Map;

public class MapWithDeleteAllKeyForValue<K, V> {
    private final Map<K, Node<V>> map = new HashMap<>();
    private final Map<V, Integer> lastDeleteForValues = new HashMap<>();
    private int counter = 0;

    public V put(K key, V value) {
        if (value == null) return remove(key);
        Node<V> prevValue = map.put(key, new Node<>(value, counter++));
        if (prevValue == null) return null;

        Integer lastDelete = lastDeleteForValues.get(prevValue.value);
        if (lastDelete == null || lastDelete < prevValue.timestamp) return prevValue.value;
        return null;
    }

    public V get(K key) {
        Node<V> node = map.get(key);
        if (node == null) return null;
        Integer lastDelete = lastDeleteForValues.get(node.value);
        if (lastDelete == null || lastDelete < node.timestamp) return node.value;
        return null;
    }

    public V remove(K key) {
        Node<V> prevValue = map.remove(key);
        if (prevValue == null) return null;
        Integer lastDelete = lastDeleteForValues.get(prevValue.value);
        if (lastDelete == null || lastDelete < prevValue.timestamp) return prevValue.value;
        return null;
    }

    public void deleteAllKeysForValue(V value) {
        lastDeleteForValues.put(value, counter++);
    }

    private record Node<V>(V value, int timestamp) {
    }
}
