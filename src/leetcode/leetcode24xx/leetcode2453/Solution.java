package leetcode.leetcode24xx.leetcode2453;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int destroyTargets(int[] nums, int space) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> minMap = new HashMap<>();
        for (int num : nums) {
            int c = num % space;
            countMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
            minMap.compute(c, (k, v) -> v == null ? num : Math.min(num, v));
        }

        long maxSum = 0;
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxSum || entry.getValue() == maxSum && ans > minMap.get(entry.getKey())) {
                maxSum = entry.getValue();
                ans = minMap.get(entry.getKey());
            }
        }
        return ans;
    }
}
