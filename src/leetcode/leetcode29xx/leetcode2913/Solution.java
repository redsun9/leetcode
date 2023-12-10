package leetcode.leetcode29xx.leetcode2913;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0, n = nums.size();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = i; j < n; j++) {
                set.add(nums.get(j));
                ans += set.size() * set.size();
            }
        }
        return ans;
    }
}
