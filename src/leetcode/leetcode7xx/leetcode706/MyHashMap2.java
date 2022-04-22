package leetcode.leetcode7xx.leetcode706;

public class MyHashMap2 {
    private static final int INIT_CAPACITY = 1 << 4;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAX_CAPACITY = 1 << 30;
    private static final int DEFAULT_VALUE = -1;
    private int capacity;
    private int size;
    private int mask;
    private Node[] nodes;

    public MyHashMap2() {
        this(INIT_CAPACITY);
    }

    private MyHashMap2(int capacity) {
        this.capacity = capacity;
        nodes = new Node[capacity];
        mask = capacity - 1;
    }

    public int get(int key) {
        int hash = hash(key);
        Node node = nodes[hash];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return DEFAULT_VALUE;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Node node = nodes[hash];
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        node = new Node(key, value);
        node.next = nodes[hash];
        nodes[hash] = node;
        if (++size > capacity * LOAD_FACTOR) {
            resize();
        }
    }

    public void remove(int key) {
        int hash = hash(key);
        Node node = nodes[hash];
        Node prev = null;
        while (node != null) {
            if (node.key == key) {
                if (prev == null) nodes[hash] = node.next;
                else prev.next = node.next;
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    private void resize() {
        if (capacity == MAX_CAPACITY) return;
        capacity <<= 1;
        mask = capacity - 1;
        Node[] oldNodes = nodes;
        nodes = new Node[capacity];
        for (Node node : oldNodes) {
            while (node != null) {
                Node next = node.next;
                int hash = hash(node.key);
                node.next = nodes[hash];
                nodes[hash] = node;
                node = next;
            }
        }
    }

    private int hash(int key) {
        key ^= key << 13;
        key ^= key >>> 17;
        key ^= key << 5;
        return key & mask;
    }

    private static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
