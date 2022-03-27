package leetcode.leetcode22xx.leetcode2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (Integer num : set1) if (!set2.contains(num)) list1.add(num);
        for (Integer num : set2) if (!set1.contains(num)) list2.add(num);
        return List.of(list1, list2);
    }
}
