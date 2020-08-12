package leetcode.leetcode3xx.leetcode349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums1) set.add(a);
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int ansLength = 0;
        for (int a : nums2) {
            if (set.remove(a)) ans[ansLength++] = a;
        }
        return Arrays.copyOfRange(ans, 0, ansLength);
    }
}
