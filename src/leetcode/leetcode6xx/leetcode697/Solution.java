package leetcode.leetcode6xx.leetcode697;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            left.putIfAbsent(num, i);
            right.put(num, i);
        }
        int maxCount = 0;
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (
                    entry.getValue() > maxCount ||
                            entry.getValue() == maxCount && ans > right.get(entry.getKey()) - left.get(entry.getKey()) + 1
            ) {
                maxCount = entry.getValue();
                ans = right.get(entry.getKey()) - left.get(entry.getKey()) + 1;
            }
        }
        return ans;
    }
}
