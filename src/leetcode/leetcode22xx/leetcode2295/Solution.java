package leetcode.leetcode22xx.leetcode2295;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> newToOld = new HashMap<>();
        for (int[] operation : operations) {
            Integer oldVal = newToOld.remove(operation[0]);
            newToOld.put(operation[1], oldVal == null ? operation[0] : oldVal);
        }

        Map<Integer, Integer> oldToNew = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : newToOld.entrySet()) oldToNew.put(entry.getValue(), entry.getKey());

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Integer newVal = oldToNew.get(nums[i]);
            if (newVal != null) nums[i] = newVal;
        }
        return nums;
    }
}
