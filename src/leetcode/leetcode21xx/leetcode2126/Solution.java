package leetcode.leetcode21xx.leetcode2126;

import java.util.Arrays;

// Time - O(NlogN), Space - o(1)
public class Solution {
    private static final int MAX_MASS = 100_000;

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int asteroid : asteroids) {
            if (mass < asteroid) return false;
            mass += asteroid;
            if (mass >= MAX_MASS) break;
        }
        return true;
    }
}
