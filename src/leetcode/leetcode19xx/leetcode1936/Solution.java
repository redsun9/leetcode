package leetcode.leetcode19xx.leetcode1936;

public class Solution {
    public int addRungs(int[] rungs, int dist) {
        int ans = 0, prev = 0, t;
        for (int rung : rungs) {
            ans += (rung - prev - 1) / dist;
            prev = rung;
        }
        return ans;
    }
}