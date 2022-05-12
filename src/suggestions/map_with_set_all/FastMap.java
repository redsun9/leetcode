package suggestions.map_with_set_all;

import java.util.HashMap;
import java.util.Map;

public class FastMap<K, V> implements MapSetAll<K, V> {
    private int size;
    private int timer;
    private final Map<K, MyRecord<V>> map;

    private int lastSetAllTime;
    private V lastSetAllValue;

    public FastMap() {
        map = new HashMap<>();
        size = 0;
        timer = 0;
        lastSetAllTime = -1;
        lastSetAllValue = null;
    }

    public V put(K key, V value) {
        if (value == null) return remove(key);
        MyRecord<V> myRecord = map.put(key, new MyRecord<>(value, timer++));
        V oldValue;
        if (myRecord == null) oldValue = null;
        else if (myRecord.time > lastSetAllTime) oldValue = myRecord.value;
        else oldValue = lastSetAllValue;

        if (oldValue == null) size++;
        return oldValue;
    }

    public V remove(K key) {
        MyRecord<V> myRecord = map.remove(key);
        V oldValue;
        if (myRecord == null) oldValue = null;
        else if (myRecord.time > lastSetAllTime) oldValue = myRecord.value;
        else oldValue = lastSetAllValue;

        if (oldValue != null) size--;
        return oldValue;
    }

    public V get(K key) {
        MyRecord<V> myRecord = map.get(key);
        V value;
        if (myRecord == null) value = null;
        else if (myRecord.time > lastSetAllTime) value = myRecord.value;
        else value = lastSetAllValue;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K key) {
        MyRecord<V> myRecord = map.get(key);
        V value;
        if (myRecord == null) value = null;
        else if (myRecord.time > lastSetAllTime) value = myRecord.value;
        else value = lastSetAllValue;
        return value != null;
    }

    public int size() {
        return size;
    }

    public void setAll(V value) {
        lastSetAllTime = timer++;
        lastSetAllValue = value;
        if (value == null) size = 0;
    }

    public void clear() {
        lastSetAllTime = timer++;
        lastSetAllValue = null;
        size = 0;
    }

    private record MyRecord<V>(V value, int time) {
    }
}
