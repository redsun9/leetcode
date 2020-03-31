package leetcode.leetcode5xx.leetcode519;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    Map<Integer, Integer> map;
    int rows, cols, total;
    Random random;

    public Solution(int rows, int cols) {
        map = new HashMap<>();
        random = new Random();
        this.rows = rows;
        this.cols = cols;
        total = rows * cols;
    }

    public int[] flip() {
        int r = random.nextInt(total--);
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        return new int[]{x / cols, x % cols};
    }

    public void reset() {
        map.clear();
        total = rows * cols;
    }
}
