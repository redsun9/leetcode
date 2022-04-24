package leetcode.leetcode7xx.leetcode705;

import java.util.BitSet;

// Array for every possible key
// Space: O(num of possible keys)
// Time: O(1)
public class MyHashSet {
    private final BitSet bitset;

    public MyHashSet() {
        bitset = new BitSet(1_000_001);
    }

    public void add(int key) {
        bitset.set(key);
    }

    public void remove(int key) {
        bitset.clear(key);
    }

    public boolean contains(int key) {
        return bitset.get(key);
    }
}
