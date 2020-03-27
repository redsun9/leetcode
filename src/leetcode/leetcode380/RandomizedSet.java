package leetcode.leetcode380;

import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, Integer> reverseMap = new HashMap<>();
    Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        int size = map.size();
        map.put(val, size);
        reverseMap.put(size, val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        Integer removedPos = map.remove(val);
        if (removedPos == null) return false;
        reverseMap.remove(removedPos);
        int size = map.size();
        if (removedPos < size) {
            Integer changedVal = reverseMap.remove(size);
            map.put(changedVal, removedPos);
            reverseMap.put(removedPos, changedVal);
        }
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return reverseMap.get(random.nextInt(reverseMap.size()));
    }
}
