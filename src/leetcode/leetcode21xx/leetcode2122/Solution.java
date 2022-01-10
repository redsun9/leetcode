package leetcode.leetcode21xx.leetcode2122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int[] recoverArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] ans = new int[n / 2];
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[0] || ((nums[i] ^ nums[0]) & 1) != 0) continue;
            int d = (nums[i] - nums[0]) >>> 1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j < i; j++) map.compute(nums[j] + 2 * d, (k, v) -> v == null ? 1 : v + 1);

            int pos = 1;
            ans[0] = nums[0] + d;

            for (int j = i + 1; j < n; j++) {
                if (map.containsKey(nums[j])) {
                    map.compute(nums[j], (k, v) -> v == 1 ? null : v - 1);
                    ans[pos++] = nums[j] - d;
                } else map.compute(nums[j] + 2 * d, (k, v) -> v == null ? 1 : v + 1);
            }
            if (map.isEmpty()) break;
        }
        return ans;
    }
}
