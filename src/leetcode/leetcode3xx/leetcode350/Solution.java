package leetcode.leetcode3xx.leetcode350;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int a : nums1) countMap.put(a, countMap.getOrDefault(a, 0) + 1);
        int[] ans = new int[nums2.length];
        int ansSize = 0;
        for (int a : nums2) {
            Integer val = countMap.get(a);
            if (val != null) {
                ans[ansSize++] = a;
                val--;
                if (val == 0) countMap.remove(a);
                else countMap.put(a, val);
            }
        }
        return Arrays.copyOfRange(ans, 0, ansSize);
    }
}
