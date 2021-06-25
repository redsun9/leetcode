package leetcode.leetcode18xx.leetcode1865;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ConstantConditions")
public class FindSumPairs {
    private final Map<Integer, Integer> map;
    private final int[] nums;
    private final int[][] first;

    public FindSumPairs(int[] nums1, int[] nums2) {
        nums = nums2;
        map = new HashMap<>();
        for (int num : nums2) map.compute(num, (k, v) -> v == null ? 1 : v + 1);

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) map1.compute(num, (k, v) -> v == null ? 1 : v + 1);
        first = new int[map1.size()][2];
        int pos = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            first[pos][0] = entry.getKey();
            first[pos++][1] = entry.getValue();
        }
    }

    public void add(int index, int val) {
        int oldVal = nums[index];
        int newVal = oldVal + val;
        nums[index] = newVal;
        map.compute(oldVal, (k, v) -> v == 1 ? null : v - 1);
        map.compute(newVal, (k, v) -> v == null ? 1 : v + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int[] entry : first) ans += entry[1] * map.getOrDefault(tot - entry[0], 0);
        return ans;
    }
}
