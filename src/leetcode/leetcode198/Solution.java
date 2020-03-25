package leetcode.leetcode198;

public class Solution {
    public int rob(int[] nums) {
        int p = 0; // -2
        int q = 0; // -1
        int r = 0;
        int tmp;
        for (int num : nums) {
            tmp = num + Math.max(p, q);
            p = q;
            q = r;
            r = tmp;
        }
        return Math.max(q, r);
    }
}
