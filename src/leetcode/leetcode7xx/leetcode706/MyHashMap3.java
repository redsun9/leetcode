package leetcode.leetcode7xx.leetcode706;

//HashMap using open addressing with linear probing
public class MyHashMap3 {
    private static final int MAX_SIZE = 10000;
    private static final int DEFAULT_SIZE = 1 << 14; // 16384
    private static final int DEFAULT_MASK = DEFAULT_SIZE - 1;
    private static final int NULL_VALUE = -1;
    private final Node[] nodes = new Node[DEFAULT_SIZE];

    public void put(int key, int value) {
        int hash = hash(key);
        while (nodes[hash] != null && nodes[hash].key != key) {
            hash = (hash + 1) & DEFAULT_MASK;
        }
        if (nodes[hash] == null) nodes[hash] = new Node(key, value);
        else nodes[hash].value = value;
    }

    public int get(int key) {
        int hash = hash(key);
        while (nodes[hash] != null && nodes[hash].key != key) {
            hash = (hash + 1) & DEFAULT_MASK;
        }
        return nodes[hash] == null ? NULL_VALUE : nodes[hash].value;
    }

    public void remove(int key) {
        int hash = hash(key);
        while (nodes[hash] != null && nodes[hash].key != key) {
            hash = (hash + 1) & DEFAULT_MASK;
        }
        if (nodes[hash] != null) nodes[hash].value = NULL_VALUE;
    }

    private int hash(int key) {
        key ^= key << 13;
        key ^= key >>> 17;
        key ^= key << 5;
        return key & DEFAULT_MASK;
    }

    private static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
