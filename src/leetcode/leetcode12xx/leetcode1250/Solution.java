package leetcode.leetcode12xx.leetcode1250;

public class Solution {
    public boolean isGoodArray(int[] nums) {
        if (nums.length == 0) return false;
        int a = nums[0];
        for (int num : nums) {
            a = gcd(a, num);
        }
        return a == 1 || a == -1;
    }

    public static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }
}
