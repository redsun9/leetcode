package leetcode.leetcode19xx.leetcode1913;

public class Solution {
    public int maxProductDifference(int[] nums) {
        int a = 0, b = 0, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > b) {
                if (num > a) {
                    b = a;
                    a = num;
                } else {
                    b = num;
                }
            }
            if (num < c) {
                if (num < d) {
                    c = d;
                    d = num;
                } else {
                    c = num;
                }
            }
        }
        return a * b - c * d;
    }
}
