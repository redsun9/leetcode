package leetcode.leetcode15xx.leetcode1512;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) count[num]++;
        int ans = 0;
        for (int c : count) ans += c * (c - 1) / 2;
        return ans;
    }
}
