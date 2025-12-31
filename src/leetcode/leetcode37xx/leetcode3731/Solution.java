package leetcode.leetcode37xx.leetcode3731;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, distinct = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            if (set.add(num)) distinct++;
        }
        List<Integer> ans = new ArrayList<>(max - min + 1 - distinct);
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}
