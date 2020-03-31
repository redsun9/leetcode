package leetcode.leetcode5xx.leetcode532;

import java.util.HashSet;

public class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> pairs = new HashSet<>();
        for (int num : nums) {
            if (!pairs.contains(num)) {
                if (seen.contains(num - k)) {
                    pairs.add(num);
                }
            }
            if (!pairs.contains(num + k)) {
                if (seen.contains(num + k)) {
                    pairs.add(num + k);
                }
            }
            seen.add(num);
        }
        return pairs.size();
    }
}
