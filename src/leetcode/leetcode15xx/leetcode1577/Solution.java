package leetcode.leetcode15xx.leetcode1577;

import java.util.HashMap;

public class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        HashMap<Long, Integer> map1 = new HashMap<>();
        for (long a : nums1) map1.put(a * a, map1.getOrDefault(a * a, 0) + 1);
        HashMap<Long, Integer> map2 = new HashMap<>();
        for (long a : nums2) map2.put(a * a, map2.getOrDefault(a * a, 0) + 1);

        int ans = 0;
        for (int i = 1; i < n; i++) {
            long a = nums2[i];
            for (int j = 0; j < i; j++) {
                ans += map1.getOrDefault(a * nums2[j], 0);
            }
        }
        for (int i = 1; i < m; i++) {
            long a = nums1[i];
            for (int j = 0; j < i; j++) {
                ans += map2.getOrDefault(a * nums1[j], 0);
            }
        }
        return ans;
    }
}
