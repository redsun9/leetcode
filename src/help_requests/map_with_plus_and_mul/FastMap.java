package help_requests.map_with_plus_and_mul;

import java.util.HashMap;
import java.util.Map;

public class FastMap implements MapWithArithmetic {
    private int size;
    private int timer;
    private final Map<Integer, MyRecord> map;
    private int lastSetAllTime;
    private Integer lastSetAllValue;
    private int valueTotalIncrement;
    private int keyTotalIncrement;

    public FastMap() {
        map = new HashMap<>();
        size = 0;
        timer = 0;
        lastSetAllTime = -1;
        lastSetAllValue = 0;
        valueTotalIncrement = 0;
    }

    @Override
    public Integer put(int key, Integer value) {
        if (value == null) return remove(key);
        MyRecord myRecord = map.put(key - keyTotalIncrement, new MyRecord(value - valueTotalIncrement, timer++));
        Integer oldValue;
        if (myRecord == null) oldValue = null;
        else if (myRecord.time > lastSetAllTime) oldValue = myRecord.value + valueTotalIncrement;
        else if (lastSetAllValue != null) oldValue = lastSetAllValue + valueTotalIncrement;
        else oldValue = null;

        if (oldValue == null) size++;
        return oldValue;
    }

    @Override
    public Integer get(int key) {
        MyRecord myRecord = map.get(key - keyTotalIncrement);
        Integer oldValue;
        if (myRecord == null) oldValue = null;
        else if (myRecord.time > lastSetAllTime) oldValue = myRecord.value + valueTotalIncrement;
        else if (lastSetAllValue != null) oldValue = lastSetAllValue + valueTotalIncrement;
        else oldValue = null;
        return oldValue;
    }

    @Override
    public Integer remove(int key) {
        MyRecord myRecord = map.remove(key - keyTotalIncrement);
        Integer oldValue;
        if (myRecord == null) oldValue = null;
        else if (myRecord.time > lastSetAllTime) oldValue = myRecord.value + valueTotalIncrement;
        else if (lastSetAllValue != null) oldValue = lastSetAllValue + valueTotalIncrement;
        else oldValue = null;

        if (oldValue != null) size--;
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        lastSetAllTime = timer++;
        lastSetAllValue = null;
        valueTotalIncrement = 0;
        keyTotalIncrement = 0;
        size = 0;
    }

    @Override
    public boolean containsKey(int key) {
        MyRecord myRecord = map.get(key - keyTotalIncrement);
        if (myRecord == null) return false;
        else if (myRecord.time > lastSetAllTime) return true;
        else return lastSetAllValue != null;
    }

    @Override
    public void increaseAllValuesBy(int increment) {
        valueTotalIncrement += increment;
    }

    @Override
    public void increaseAllKeysBy(int increment) {
        valueTotalIncrement += increment;
    }

    @Override
    public void setAll(Integer value) {
        lastSetAllTime = timer++;
        lastSetAllValue = value;
        valueTotalIncrement = 0;
        if (value == null) size = 0;
    }

    private record MyRecord(int value, int time) {
    }
}
