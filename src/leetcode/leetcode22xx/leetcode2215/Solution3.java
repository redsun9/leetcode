package leetcode.leetcode22xx.leetcode2215;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    private static final int MIN_VAL = -1000;
    private static final int MAX_VAL = 1000;
    private static final int total = MAX_VAL - MIN_VAL + 1;

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] b1 = new boolean[total], b2 = new boolean[total];
        for (int num : nums1) b1[num - MIN_VAL] = true;
        for (int num : nums2) b2[num - MIN_VAL] = true;

        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            if (b1[i] && !b2[i]) list1.add(MIN_VAL + i);
            else if (!b1[i] && b2[i]) list2.add(MIN_VAL + i);
        }
        return List.of(list1, list2);
    }
}
