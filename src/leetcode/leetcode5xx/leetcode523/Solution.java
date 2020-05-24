package leetcode.leetcode5xx.leetcode523;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0) {
            for (int i = nums.length - 1; i > 0; i--) if (nums[i] == 0 && nums[i - 1] == 0) return true;
            return false;
        } else if (k == 1 || k == -1) return nums.length >= 2;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            Integer prev = map.get(sum);
            if (prev != null) {
                if (i - prev > 1) return true;
            } else map.put(sum, i);
        }
        return false;
    }
}
