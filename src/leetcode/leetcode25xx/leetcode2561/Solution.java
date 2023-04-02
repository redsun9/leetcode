package leetcode.leetcode25xx.leetcode2561;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int min = Integer.MAX_VALUE;
        for (int i : basket1) min = Math.min(min, i);
        for (int i : basket2) min = Math.min(min, i);

        BiFunction<Integer, Integer, Integer> increment = (a, b) -> b == null ? 1 : b + 1;
        BiFunction<Integer, Integer, Integer> decrement = (a, b) -> b == null ? -1 : b - 1;
        HashMap<Integer, Integer> diff = new HashMap<>();
        for (int i : basket1) diff.compute(i, increment);
        for (int i : basket2) diff.compute(i, decrement);

        //check that all even
        for (Integer value : diff.values()) if ((value & 1) != 0) return -1;
        int diffSize = 0;
        for (Integer value : diff.values()) diffSize += Math.abs(value);
        diffSize /= 4;
        int[] arr1 = new int[diffSize];
        int[] arr2 = new int[diffSize];
        int i1 = 0, i2 = 0;
        for (Map.Entry<Integer, Integer> pair : diff.entrySet()) {
            int value = pair.getValue();
            int key = pair.getKey();
            if (value > 0) {
                Arrays.fill(arr1, i1, i1 + value / 2, key);
                i1 += value / 2;
            } else if (value < 0) {
                Arrays.fill(arr2, i2, i2 - value / 2, key);
                i2 -= value / 2;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        long ans = 0;

        for (int l = 0, r = diffSize - 1; l <= r; l++, r--) {
            int tmp = Math.min(arr1[l], arr2[r]);
            ans += Math.min(tmp, min * 2);
            if (l != r) {
                tmp = Math.min(arr1[r], arr2[l]);
                ans += Math.min(tmp, min * 2);
            }
        }
        return ans;
    }
}
