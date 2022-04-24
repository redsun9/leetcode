package leetcode.leetcode7xx.leetcode706;

// Array for every possible key
// Space: O(num of possible keys)
// Time: O(1)

public class MyHashMap {
    private final Integer[] arr;

    public MyHashMap() {
        arr = new Integer[1_000_001];
    }

    public void put(int key, int value) {
        arr[key] = value;
    }

    public int get(int key) {
        Integer ans = arr[key];
        return ans == null ? -1 : ans;
    }

    public void remove(int key) {
        arr[key] = null;
    }
}
