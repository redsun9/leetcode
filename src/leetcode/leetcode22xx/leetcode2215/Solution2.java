package leetcode.leetcode22xx.leetcode2215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length, n2 = nums2.length, i11 = 0, i12 = 1, i21 = 0, i22 = 1;
        while (i11 != n1 || i21 != n2) {
            //skip same elements
            while (i12 < n1 && nums1[i11] == nums1[i12]) {
                i11++;
                i12++;
            }
            //skip same elements
            while (i22 < n2 && nums2[i21] == nums2[i22]) {
                i21++;
                i22++;
            }
            if (i11 < n1 && (i21 >= n2 || nums2[i21] > nums1[i11])) {
                list1.add(nums1[i11]);
                i11++;
                i12++;
            } else if (i21 < n2 && (i11 >= n1 || nums1[i11] > nums2[i21])) {
                list2.add(nums2[i21]);
                i21++;
                i22++;
            } else {
                i11++;
                i12++;
                i21++;
                i22++;
            }
        }
        return List.of(list1, list2);
    }
}
