package leetcode.leetcode381;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;

public class RandomizedCollection {
    HashMap<Integer, LinkedHashSet<Integer>> valToPosSet = new HashMap<>();
    HashMap<Integer, Integer> positionToVal = new HashMap<>();
    Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        LinkedHashSet<Integer> set = valToPosSet.getOrDefault(val, new LinkedHashSet<>());
        int size = positionToVal.size();
        set.add(size);
        positionToVal.put(size, val);
        valToPosSet.put(val, set);
        return set.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        LinkedHashSet<Integer> set = valToPosSet.get(val);
        if (set == null) return false;
        Integer prevPos = set.iterator().next();
        set.remove(prevPos);
        if (set.isEmpty()) valToPosSet.remove(val);
        positionToVal.remove(prevPos);
        int size = positionToVal.size();
        if (prevPos < size) {
            Integer changedVal = positionToVal.remove(size);
            LinkedHashSet<Integer> changedSet = valToPosSet.get(changedVal);
            changedSet.remove(size);
            changedSet.add(prevPos);
            positionToVal.put(prevPos, changedVal);
        }
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return positionToVal.get(random.nextInt(positionToVal.size()));
    }
}
