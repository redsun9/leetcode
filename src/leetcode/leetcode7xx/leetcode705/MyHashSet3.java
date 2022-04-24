package leetcode.leetcode7xx.leetcode705;

import java.util.Arrays;

//HashSet using open addressing with linear probing and resizing
public class MyHashSet3 {
    private static final int MAX_CAPACITY = 1 << 30;
    private static final int INIT_CAPACITY = 1 << 4;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int NULL_VALUE = -1;
    private int capacity;
    private int used;
    private int mask;
    private int[] nodes;
    private boolean[] deleted;

    public MyHashSet3() {
        capacity = INIT_CAPACITY;
        mask = capacity - 1;
        nodes = new int[capacity];
        deleted = new boolean[capacity];
        Arrays.fill(nodes, NULL_VALUE);
    }

    public void add(int key) {
        int hash = hash(key);
        while (nodes[hash] != NULL_VALUE && nodes[hash] != key) {
            hash = (hash + 1) & mask;
        }
        if (nodes[hash] == NULL_VALUE || deleted[hash]) {
            if (nodes[hash] == NULL_VALUE) ++used;
            nodes[hash] = key;
            deleted[hash] = false;
            if (used > capacity * LOAD_FACTOR) {
                resize();
            }
        }
    }

    public boolean contains(int key) {
        int hash = hash(key);
        while (nodes[hash] != NULL_VALUE && nodes[hash] != key) {
            hash = (hash + 1) & mask;
        }
        return nodes[hash] != NULL_VALUE && !deleted[hash];
    }

    public void remove(int key) {
        int hash = hash(key);
        while (nodes[hash] != NULL_VALUE && nodes[hash] != key) {
            hash = (hash + 1) & mask;
        }
        if (nodes[hash] != NULL_VALUE && !deleted[hash]) {
            if (nodes[hash] == key) deleted[hash] = true;
        }
    }

    private void resize() {
        if (capacity == MAX_CAPACITY) return;
        capacity <<= 1;
        mask = capacity - 1;
        int[] oldNodes = nodes;
        boolean[] oldDeleted = deleted;
        nodes = new int[capacity];
        deleted = new boolean[capacity];
        used = 0;
        Arrays.fill(nodes, NULL_VALUE);
        for (int i = 0; i < oldNodes.length; i++) {
            int key = oldNodes[i];
            if (key == NULL_VALUE || oldDeleted[i]) continue;
            used++;
            int hash = hash(key);
            while (nodes[hash] != NULL_VALUE) hash = (hash + 1) & mask;
            nodes[hash] = key;
        }
    }

    private int hash(int key) {
        int hash = 0;

        for (int i = 0; i < 4; i++) {
            hash += key >>> i * 8 & 0xFF;
            hash += hash << 10;
            hash ^= hash >>> 6;
        }
        hash += hash << 3;
        hash ^= hash >>> 11;
        hash += hash << 15;
        return hash & mask;
    }
}
