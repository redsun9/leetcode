package leetcode.leetcode7xx.leetcode706;

// HashMap using Cuckoo Hashing

public class MyHashMap5 {
    private static final int MAX_CAPACITY = 1 << 30;
    private static final int DEFAULT_SIZE = 1 << 4;
    private static final int MAX_LOOP = 10;
    private static final int NULL_VALUE = -1;
    private int capacity, mask;
    private Node[] table1;
    private Node[] table2;
    private int randomState = 1;
    private int seed1, seed2;

    public MyHashMap5() {
        capacity = DEFAULT_SIZE;
        mask = capacity - 1;
        table1 = new Node[capacity];
        table2 = new Node[capacity];
        seed1 = nextInt();
        seed2 = nextInt();
    }

    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (table1[hash1] != null && table1[hash1].key == key) {
            table1[hash1] = null;
        }
        if (table2[hash2] != null && table2[hash2].key == key) {
            table2[hash2] = null;
        }
    }

    public void put(int key, int value) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (table1[hash1] != null && table1[hash1].key == key) {
            table1[hash1].value = value;
            return;
        }
        if (table2[hash2] != null && table2[hash2].key == key) {
            table2[hash2].value = value;
            return;
        }
        if (table1[hash1] == null) {
            table1[hash1] = new Node(key, value);
            return;
        }
        if (table2[hash2] == null) {
            table2[hash2] = new Node(key, value);
            return;
        }

        int loop = 0;
        while (loop < MAX_LOOP) {
            //try to find an empty slot in table1
            if (table1[hash1] == null) {
                table1[hash1] = new Node(key, value);
                return;
            }

            // x <-> T1[h1(x))]
            int tmpKey = table1[hash1].key;
            int tmpValue = table1[hash1].value;
            table1[hash1].key = key;
            table1[hash1].value = value;
            key = tmpKey;
            value = tmpValue;
            hash2 = hash2(key);

            //try to find an empty slot in table2
            if (table2[hash2] == null) {
                table2[hash2] = new Node(key, value);
                return;
            }

            // x <-> T2[h2(x))]
            tmpKey = table2[hash2].key;
            tmpValue = table2[hash2].value;
            table2[hash2].key = key;
            table2[hash2].value = value;
            key = tmpKey;
            value = tmpValue;
            hash1 = hash1(key);
            loop++;
        }
        rehash();
        put(key, value);
    }

    public int get(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (table1[hash1] != null && table1[hash1].key == key) {
            return table1[hash1].value;
        }
        if (table2[hash2] != null && table2[hash2].key == key) {
            return table2[hash2].value;
        }
        return NULL_VALUE;
    }

    private void rehash() {
        Node[] tmp1 = table1;
        Node[] tmp2 = table2;
        if (capacity != MAX_CAPACITY) {
            capacity = capacity << 1;
            mask = capacity - 1;
        }
        table1 = new Node[capacity];
        table2 = new Node[capacity];
        seed1 = nextInt();
        seed2 = nextInt();

        for (Node node : tmp1) if (node != null) put(node.key, node.value);
        for (Node node : tmp2) if (node != null) put(node.key, node.value);
    }

    private int hash1(int key) {
        return spookyHash(seed1, key) & mask;
    }

    private int hash2(int key) {
        return spookyHash(seed2, key) & mask;
    }

    private static int spookyHash(int seed, int key) {
        int hash = seed;

        for (int i = 0; i < 4; i++) {
            hash += key >>> i * 8 & 0xFF;
            hash += hash << 10;
            hash ^= hash >>> 6;
        }
        hash += hash << 3;
        hash ^= hash >>> 11;
        hash += hash << 15;
        return hash;
    }

    private int nextInt() {
        randomState ^= randomState << 13;
        randomState ^= randomState >>> 17;
        randomState ^= randomState << 5;
        return randomState;
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
