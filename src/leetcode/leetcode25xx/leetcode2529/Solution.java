package leetcode.leetcode25xx.leetcode2529;

public class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0, pos = 0;
        for (int num : nums) {
            if (num < 0) neg++;
            else if (num != 0) pos++;
        }
        return Math.max(pos, neg);
    }
}
