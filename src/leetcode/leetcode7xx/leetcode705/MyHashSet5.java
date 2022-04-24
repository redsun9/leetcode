package leetcode.leetcode7xx.leetcode705;


import java.util.Arrays;

// HashSet using Cuckoo Hashing
public class MyHashSet5 {
    private static final int MAX_CAPACITY = 1 << 30;
    private static final int DEFAULT_SIZE = 1 << 4;
    private static final int MAX_LOOP = 10;
    private static final int NULL_VALUE = -1;
    private int capacity, mask;
    private int[] table1;
    private int[] table2;
    private int randomState = 1;
    private int seed1, seed2;

    public MyHashSet5() {
        capacity = DEFAULT_SIZE;
        mask = capacity - 1;
        table1 = new int[capacity];
        table2 = new int[capacity];
        Arrays.fill(table1, NULL_VALUE);
        Arrays.fill(table2, NULL_VALUE);
        seed1 = nextInt();
        seed2 = nextInt();
    }

    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (table1[hash1] == key) table1[hash1] = NULL_VALUE;
        if (table2[hash2] == key) table2[hash2] = NULL_VALUE;
    }

    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (table1[hash1] == NULL_VALUE || table1[hash1] == key) {
            table1[hash1] = key;
            return;
        }
        if (table2[hash2] == NULL_VALUE || table2[hash2] == key) {
            table2[hash2] = key;
            return;
        }

        int loop = 0;
        while (loop < MAX_LOOP) {
            //try to find an empty slot in table1
            if (table1[hash1] == NULL_VALUE) {
                table1[hash1] = key;
                return;
            }

            // x <-> T1[h1(x))]
            int tmpKey = table1[hash1];
            table1[hash1] = key;
            key = tmpKey;
            hash2 = hash2(key);

            //try to find an empty slot in table2
            if (table2[hash2] == NULL_VALUE) {
                table2[hash2] = key;
                return;
            }

            // x <-> T2[h2(x))]
            tmpKey = table2[hash2];
            table2[hash2] = key;
            key = tmpKey;
            hash1 = hash1(key);
            loop++;
        }
        rehash();
        add(key);
    }

    public boolean contains(int key) {
        return table1[hash1(key)] == key || table2[hash2(key)] == key;
    }

    private void rehash() {
        int[] tmp1 = table1;
        int[] tmp2 = table2;
        if (capacity != MAX_CAPACITY) {
            capacity = capacity << 1;
            mask = capacity - 1;
        }
        table1 = new int[capacity];
        table2 = new int[capacity];
        Arrays.fill(table1, NULL_VALUE);
        Arrays.fill(table2, NULL_VALUE);
        seed1 = nextInt();
        seed2 = nextInt();

        for (int node : tmp1) if (node != NULL_VALUE) add(node);
        for (int node : tmp2) if (node != NULL_VALUE) add(node);
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
}
