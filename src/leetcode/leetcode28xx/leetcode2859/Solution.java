package leetcode.leetcode28xx.leetcode2859;

import java.util.List;

public class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) if (Integer.bitCount(i) == k) ans += nums.get(i);
        return ans;
    }
}
