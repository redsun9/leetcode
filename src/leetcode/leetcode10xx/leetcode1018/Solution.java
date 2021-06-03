package leetcode.leetcode10xx.leetcode1018;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>(nums.length);
        int a = 0;
        for (int num : nums) {
            a = (a * 2 + num) % 5;
            ans.add(a == 0);
        }
        return ans;
    }
}
