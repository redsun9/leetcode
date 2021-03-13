package leetcode.leetcode17xx.leetcode1785;

public class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long s = 0;
        for (int num : nums) s += num;
        return (int) ((Math.abs(s - goal) + limit - 1) / limit);
    }
}
