package leetcode.leetcode29xx.leetcode2956;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        return new int[]{
                intersectionCount(nums1, nums2),
                intersectionCount(nums2, nums1)
        };
    }

    private static int intersectionCount(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums2) set.add(num);
        int ans = 0;
        for (int num : nums1) if (set.contains(num)) ans++;
        return ans;
    }
}
