package leetcode.leetcode21xx.leetcode2126;

// Time - O(MAX_MASS + n), Space - O(MAX_MASS)
public class Solution2 {
    private static final int MAX_MASS = 100_000;

    public boolean asteroidsDestroyed(long mass, int[] asteroids) {
        int[] count = new int[MAX_MASS + 1];
        for (int asteroid : asteroids) count[asteroid]++;

        for (int i = 0; mass < MAX_MASS && i <= MAX_MASS; i++) {
            if (count[i] != 0) {
                if (mass < i) return false;
                mass += (long) i * count[i];
            }
        }
        return true;
    }
}
