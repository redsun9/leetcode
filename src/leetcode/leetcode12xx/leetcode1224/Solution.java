package leetcode.leetcode12xx.leetcode1224;

import java.util.HashMap;

public class Solution {
    public int maxEqualFreq(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> intMap = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int ans = 0;
        int minCount = 0, maxCount = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int prevCount = intMap.getOrDefault(num, 0);
            intMap.put(num, prevCount + 1);
            if (prevCount != 0) {
                Integer newValueForPrevCount = countMap.compute(prevCount, (key, val) -> val != 1 ? val - 1 : null);
                if (minCount == prevCount && newValueForPrevCount == null) minCount++;
            } else minCount = 1;
            countMap.compute(prevCount + 1, (key, val) -> val != null ? val + 1 : 1);
            maxCount = Math.max(maxCount, prevCount + 1);
            if (countMap.size() <= 2) {
                if (
                        minCount + 1 == maxCount && countMap.get(maxCount) == 1
                                || minCount == 1 && countMap.get(minCount) == 1
                                || maxCount == 1
                                || intMap.size() == 1
                ) ans = i;
            }
        }
        return ans + 1;
    }
}
