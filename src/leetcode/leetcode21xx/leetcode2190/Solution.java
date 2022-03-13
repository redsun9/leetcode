package leetcode.leetcode21xx.leetcode2190;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int mostFrequent(int[] nums, int key) {
        int n = nums.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) if (nums[i] == key) map.compute(nums[i + 1], (k, v) -> v == null ? 1 : v + 1);

        int ans = 0, ansCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > ansCount) {
                ansCount = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
