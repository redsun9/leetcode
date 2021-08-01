package leetcode.leetcode19xx.leetcode1955;

public class Solution {
    private static final int p = 1_000_000_007;

    public int countSpecialSubsequences(int[] nums) {
        int n = nums.length;
        long c0 = 0, c1 = 0, c2 = 0;
        for (int num : nums) {
            if (num == 0) {
                c0 = c0 * 2 + 1;
                while (c0 >= p) c0 -= p;
            } else if (num == 1) {
                c1 = c1 * 2 + c0;
                while (c1 >= p) c1 -= p;
            } else {
                c2 = c2 * 2 + c1;
                while (c2 >= p) c2 -= p;
            }
        }
        return (int) (c2);
    }
}
