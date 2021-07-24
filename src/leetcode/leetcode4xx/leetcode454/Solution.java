package leetcode.leetcode4xx.leetcode454;

import java.util.HashMap;

public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) for (int b : nums2) map.compute(a + b, (k, v) -> v == null ? 1 : v + 1);
        int ans = 0;
        for (int a : nums3) for (int b : nums4) ans += map.getOrDefault(-a - b, 0);
        return ans;
    }
}
