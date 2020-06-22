package leetcode.leetcode10xx.leetcode1013;

public class Solution {
    public boolean canThreePartsEqualSum(int[] nums) {
        int s = 0;
        for (int num : nums) s += num;
        if (s % 3 != 0) return false;
        int target = s / 3;
        int count = 0;
        s = 0;
        for (int num : nums) {
            s += num;
            if (s == target) {
                count++;
                s = 0;
            }
        }
        return count >= 3;
    }
}
