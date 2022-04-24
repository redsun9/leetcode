package leetcode.leetcode7xx.leetcode705;

// HashSet using collision resolution by chaining and resizing.

public class MyHashSet2 {
    private static final int INIT_CAPACITY = 1 << 4;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAX_CAPACITY = 1 << 30;
    private int capacity;
    private int size;
    private int mask;

    private Node[] nodes;

    public MyHashSet2() {
        capacity = INIT_CAPACITY;
        mask = capacity - 1;
        nodes = new Node[capacity];
    }

    public boolean contains(int key) {
        int hash = hash(key);
        Node node = nodes[hash];
        while (node != null) {
            if (node.key == key) return true;
            node = node.next;
        }
        return false;
    }

    public void add(int key) {
        int hash = hash(key);
        Node node = nodes[hash];
        while (node != null) {
            if (node.key == key) return;
            node = node.next;
        }
        node = new Node(key);
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

    private static class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }
}
