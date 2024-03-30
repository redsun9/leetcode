package leetcode.leetcode29xx.leetcode2980;

public class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int cnt = 0;
        for (int num : nums) if ((num & 1) == 0) if (++cnt == 2) return true;
        return false;
    }
}
