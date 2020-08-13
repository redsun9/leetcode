package leetcode.leetcode5xx.leetcode506;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        String[] ans = new String[n];
        List<Integer> ranks = IntStream.range(0, n)
                .boxed()
                .sorted(Comparator.comparingInt(ind -> -nums[ind]))
                .collect(Collectors.toList());
        if (n > 0) ans[ranks.get(0)] = "Gold Medal";
        if (n > 1) ans[ranks.get(1)] = "Silver Medal";
        if (n > 2) ans[ranks.get(2)] = "Bronze Medal";
        for (int i = 3; i < n; i++) {
            ans[ranks.get(i)] = Integer.toString(i + 1);
        }
        return ans;
    }
}
