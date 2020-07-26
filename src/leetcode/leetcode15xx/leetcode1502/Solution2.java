package leetcode.leetcode15xx.leetcode1502;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        if (n <= 2) return true;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        if ((max - min) % (n - 1) != 0) return false;
        int d = (max - min) / (n - 1);
        if (d == 0) return true;
        Set<Integer> set = new HashSet<>();
        for (int a : arr) {
            if ((a - min) % d != 0) return false;
            if (!set.add(a)) return false;
        }
        return true;
    }
}
