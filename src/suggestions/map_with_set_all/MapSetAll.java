package suggestions.map_with_set_all;

public interface MapSetAll<K, V> {
    V put(K key, V value);

    V get(K key);

    V remove(K key);

    int size();

    boolean isEmpty();

    void clear();

    boolean containsKey(K key);

    void setAll(V value);
}
