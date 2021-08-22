package leetcode.leetcode19xx.leetcode1981;

import java.util.Arrays;

public class Solution {
    private static final int MAX_VALUE = 5000;

    public int minimizeTheDifference(int[][] mat, int target) {
        boolean[] prev = new boolean[MAX_VALUE + 1], next = new boolean[MAX_VALUE + 1], tmp;
        prev[0] = true;
        for (int[] row : mat) {
            Arrays.fill(next, false);
            for (int num : row) {
                for (int i = 0, j = num; j <= MAX_VALUE; i++, j++) next[j] |= prev[i];
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }
        int floor = target, ceil = target;
        while (floor >= 0 && !prev[floor]) floor--;
        while (ceil <= MAX_VALUE && !prev[ceil]) ceil++;
        if (floor < 0) return ceil - target;
        if (ceil > MAX_VALUE) return target - floor;
        return Math.min(ceil - target, target - floor);
    }
}
