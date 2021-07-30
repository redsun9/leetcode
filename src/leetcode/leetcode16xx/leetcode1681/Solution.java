package leetcode.leetcode16xx.leetcode1681;

import java.util.Arrays;

public class Solution {
    private static int dfs(int i, int m, int n, int key, int[] nums, int[] cache) {
        if (cache[key] == 0) {
            if (i == 1) {
                int tmp = incompatibility(key, n, nums);
                cache[key] = tmp == -1 ? -1 : tmp + 1;
            } else {
                int tmp = Integer.MAX_VALUE;
                int highestBit = Integer.highestOneBit(key);
                key ^= highestBit;
                int mask = key;
                while (true) {
                    if (Integer.bitCount(mask) == m - 1) {
                        int tmp1 = dfs(1, m, n, mask ^ highestBit, nums, cache);
                        if (tmp1 == -1) {
                            mask = (mask - 1) & key;
                            continue;
                        }
                        int tmp2 = dfs(i - 1, m, n, key ^ mask, nums, cache);
                        if (tmp2 == -1) {
                            mask = (mask - 1) & key;
                            continue;
                        }
                        tmp = Math.min(tmp, tmp1 + tmp2);
                    }
                    if (mask == 0) break;
                    mask = (mask - 1) & key;
                }
                key ^= highestBit;
                cache[key] = tmp == Integer.MAX_VALUE ? -1 : tmp + 1;
            }
        }
        return cache[key] == -1 ? -1 : cache[key] - 1;
    }

    private static int incompatibility(int key, int n, int[] nums) {
        int first = 0, last = 0;
        int previous = 0;
        for (int i = 0; i < n; i++) {
            if ((key >>> i & 1) != 0) {
                if (first == 0) first = nums[i];
                last = nums[i];
                if (previous == last) return -1;
                previous = last;
            }
        }
        return last - first;
    }

    public int minimumIncompatibility(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (k == n) return 0;
        if (k == 1) return incompatibility((1 << n) - 1, n, nums);
        return dfs(k, n / k, n, (1 << n) - 1, nums, new int[1 << n]);
    }
}
