package leetcode.leetcode7xx.leetcode710;

import java.util.HashMap;
import java.util.Random;

public class Solution {
    private HashMap<Integer, Integer> instead = new HashMap<>();
    private Random random = new Random();
    private final int total;

    public Solution(int n, int[] blacklist) {
        total = n - blacklist.length;
        for (int b : blacklist) {
            instead.put(b, -1);
        }
        for (int b : blacklist) {
            if (b < total) {
                while (instead.containsKey(n - 1))
                    n--;
                instead.put(b, n - 1);
                n--;
            }
        }
    }

    public int pick() {
        int p = random.nextInt(total);
        return instead.getOrDefault(p, p);
    }
}
