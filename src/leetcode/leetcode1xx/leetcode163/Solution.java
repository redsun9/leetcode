package leetcode.leetcode1xx.leetcode163;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        if (n == 0) return singletonList(getRange(lower - 1L, upper + 1L));
        List<String> ans = new ArrayList<>();
        String startRange = getRange(lower - 1L, nums[0]);
        if (startRange != null) ans.add(startRange);

        for (int i = 1; i < n; i++) {
            String range = getRange(nums[i - 1], nums[i]);
            if (range != null) ans.add(range);
        }

        String endRange = getRange(nums[n - 1], upper + 1L);
        if (endRange != null) ans.add(endRange);
        return ans;
    }

    private static String getRange(long start, long end) {
        if (end - start <= 1) return null;
        if (end == start + 2) return Long.toString(start + 1);
        else return (start + 1) + "->" + (end - 1);
    }
}
