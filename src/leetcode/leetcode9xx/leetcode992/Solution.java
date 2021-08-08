package leetcode.leetcode9xx.leetcode992;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans = 0, n = nums.length;
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int l1 = 0, l2 = 0, c1 = 0, c2 = 0, r = 0; r < n; r++) {
            if (map1.compute(nums[r], (key, v) -> v == null ? 1 : v + 1) == 1) c1++;
            if (map2.compute(nums[r], (key, v) -> v == null ? 1 : v + 1) == 1) c2++;
            while (c1 > k) if (map1.compute(nums[l1++], (key, v) -> v - 1) == 0) c1--;
            while (c2 >= k) if (map2.compute(nums[l2++], (key, v) -> v - 1) == 0) c2--;
            if (c1 == k) ans += l2 - l1;
        }
        return ans;
    }
}
