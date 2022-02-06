package leetcode.leetcode21xx.leetcode2148;

public class Solution {
    public int countElements(int[] nums) {
        int min = nums[0], max = nums[0], countMin = 0, countMax = 0;
        for (int num : nums) {
            if (num < min) {
                min = num;
                countMin = 1;
            } else if (num > max) {
                max = num;
                countMax = 1;
            } else {
                if (num == min) {
                    countMin++;
                    if (min == max) countMax++;
                } else if (num == max) countMax++;
            }
        }
        return min == max ? 0 : nums.length - countMin - countMax;
    }
}
