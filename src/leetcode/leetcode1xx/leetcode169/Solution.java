package leetcode.leetcode1xx.leetcode169;

public class Solution {
    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                count = 1;
                major = num;
            } else if (major == num) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
