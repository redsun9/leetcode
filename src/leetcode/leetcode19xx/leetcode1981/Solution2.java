package leetcode.leetcode19xx.leetcode1981;

import java.util.BitSet;

public class Solution2 {
    private static final int MAX_VALUE = 5000;

    public int minimizeTheDifference(int[][] mat, int target) {
        BitSet prev = new BitSet(MAX_VALUE), next;
        prev.set(MAX_VALUE - 1);
        for (int[] row : mat) {
            next = new BitSet(MAX_VALUE);
            for (int num : row) next.or(prev.get(num, MAX_VALUE));
            prev = next;
        }
        target = MAX_VALUE - 1 - target;
        int floor = prev.previousSetBit(target), ceil = prev.nextSetBit(target);
        if (floor < 0) return ceil - target;
        if (ceil < 0) return target - floor;
        return Math.min(ceil - target, target - floor);
    }
}
