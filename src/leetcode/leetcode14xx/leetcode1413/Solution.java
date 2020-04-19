package leetcode.leetcode14xx.leetcode1413;

public class Solution {
    public int minStartValue(int[] nums) {
        int min = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.max(min, -sum + 1);
        }
        return min;
    }
}
