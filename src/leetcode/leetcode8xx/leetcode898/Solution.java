package leetcode.leetcode8xx.leetcode898;

import java.util.HashSet;

public class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();
        for (int a : nums) {
            HashSet<Integer> curr = new HashSet<>();
            curr.add(a);
            for (int b : prev) {
                curr.add(a | b);
            }
            ans.addAll(curr);
            prev = curr;
        }
        return ans.size();
    }
}
