package leetcode.leetcode7xx.leetcode740;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] a = new int[10000 + 1];
        for (int num : nums) a[num] += num;

        //house robber
        int p = 0; // -2
        int q = 0; // -1
        int r = 0;
        int tmp;
        for (int num : a) {
            tmp = num + Math.max(p, q);
            p = q;
            q = r;
            r = tmp;
        }
        return Math.max(q, r);
    }
}
