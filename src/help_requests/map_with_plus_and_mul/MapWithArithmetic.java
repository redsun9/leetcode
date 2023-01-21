package help_requests.map_with_plus_and_mul;

public interface MapWithArithmetic {
    Integer put(int key, Integer value);

    Integer get(int key);

    Integer remove(int key);

    int size();

    boolean isEmpty();

    void clear();

    boolean containsKey(int key);

    void increaseAllValuesBy(int increment);

    void increaseAllKeysBy(int increment);

    void setAll(Integer value);

}
