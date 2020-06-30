package leetcode.leetcode12xx.leetcode1262;

public class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] prev = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] next = new int[3];
        for (int num : nums) {
            for (int i = 0; i < 3; i++) {
                next[(i + num) % 3] = Math.max(prev[(i + num) % 3], prev[i] + num);
            }
            int[] tmp = next;
            next = prev;
            prev = tmp;
        }
        return prev[0];
    }
}
