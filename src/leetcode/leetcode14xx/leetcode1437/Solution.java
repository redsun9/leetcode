package leetcode.leetcode14xx.leetcode1437;

public class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) return true;
        int needSpaces = 0;
        for (int num : nums) {
            if (num == 1) {
                if (needSpaces > 0) return false;
                needSpaces = k;
            } else needSpaces--;
        }
        return true;
    }
}
