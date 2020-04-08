package basic;


import java.util.Arrays;

//0 - element missing
public class MaxHeap {
    private static final int DEFAULT_CAPACITY = 16;
    int[] h;
    int capacity;
    private boolean shouldRebalance = true;

    public MaxHeap(int[] arr, boolean shouldRebalance) {
        this(arr);
        this.shouldRebalance = shouldRebalance;
    }

    public MaxHeap(int capacity, boolean shouldRebalance) {
        this.shouldRebalance = shouldRebalance;
        this.capacity = capacity;
        h = new int[capacity + 1];
    }

    public MaxHeap(int[] arr) {
        capacity = arr.length;
        h = new int[capacity + 1];
        for (int a : arr) {
            h[++h[0]] = a;
            int tmp = h[0];
            while (tmp != 1) {
                int parent = tmp >> 1;
                if (h[tmp] > h[parent]) {
                    int c = h[tmp];
                    h[tmp] = h[parent];
                    h[parent] = c;
                    tmp = parent;
                } else break;
            }
        }
    }

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        h = new int[capacity + 1];
    }

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public int poll() {
        int ans = h[1];
        int tmp = 1;
        while (true) {
            int leftChild = (tmp << 1);
            int rightChild = (tmp << 1) + 1;
            if (rightChild <= capacity) {
                if (h[rightChild] > h[leftChild]) {
                    h[tmp] = h[rightChild];
                    tmp = rightChild;
                } else {
                    h[tmp] = h[leftChild];
                    tmp = leftChild;
                }
            } else if (leftChild <= capacity) {
                h[tmp] = h[leftChild];
                tmp = leftChild;
            } else {
                h[tmp] = 0;
            }
            if (h[tmp] == 0) break;
        }
        if (shouldRebalance && tmp != h[0]) {
            h[tmp] = h[h[0]];
            h[h[0]] = 0;
            while (tmp != 1) {
                int parent = tmp >> 1;
                if (h[tmp] > h[parent]) {
                    int c = h[tmp];
                    h[tmp] = h[parent];
                    h[parent] = c;
                    tmp = parent;
                } else break;
            }
        }
        h[0]--;
        if (h[0] < 0) h[0] = 0;
        return ans;
    }

    public void add(int val) {
        if (shouldRebalance) {
            if (h[0] >= capacity) {
                capacity *= 2;
                h = Arrays.copyOf(h, capacity + 1);
            }
            h[++h[0]] = val;
            int tmp = h[0];
            while (tmp != 1) {
                int parent = tmp >> 1;
                if (h[tmp] > h[parent]) {
                    int c = h[tmp];
                    h[tmp] = h[parent];
                    h[parent] = c;
                    tmp = parent;
                } else break;
            }
        } else throw new UnsupportedOperationException();
    }
}
