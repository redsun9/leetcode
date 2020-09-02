package leetcode.leetcode2xx.leetcode220;

import java.util.NavigableSet;
import java.util.TreeSet;

// O(NlogK)
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if (n <= 1 || t < 0 || k <= 0) return false;
        long maxDiff = 2L * t;
        NavigableSet<Long> set = new TreeSet<>();
        for (int i = 0, j = -k - 1; i < n; i++, j++) {
            if (j >= 0) set.remove((long) nums[j]);
            long num = ((long) nums[i]) - t;
            Long ceiling = set.ceiling(num);
            if (ceiling != null && ceiling - num <= maxDiff) return true;
            set.add((long) nums[i]);
        }
        return false;
    }
}
