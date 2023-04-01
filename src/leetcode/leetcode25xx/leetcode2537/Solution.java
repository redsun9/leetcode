package leetcode.leetcode25xx.leetcode2537;

import java.util.HashMap;

public class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long ans = n * (n + 1L) / 2;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int r = 0, l = 0, nPairs = 0; r < n; r++) {
            int num = nums[r];
            nPairs += map.compute(num, (k1, v) -> v == null ? 1 : v + 1) - 1;
            while (nPairs >= k) {
                num = nums[l++];
                Integer left = map.compute(num, (k1, v) -> v == 1 ? null : v - 1);
                if (left != null) nPairs -= left;
            }
            ans -= r - l + 1;
        }
        return ans;
    }
}
