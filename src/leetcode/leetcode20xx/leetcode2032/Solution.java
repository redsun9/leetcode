package leetcode.leetcode20xx.leetcode2032;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int MAX_VAL = 100;

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] count = new int[MAX_VAL + 1];
        for (int i : nums1) count[i] |= 1;
        for (int i : nums2) count[i] |= 2;
        for (int i : nums3) count[i] |= 4;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= MAX_VAL; i++) if (Integer.bitCount(count[i]) >= 2) ans.add(i);
        return ans;
    }
}
