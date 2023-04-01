package leetcode.leetcode25xx.leetcode2535;

public class Solution {
    public int differenceOfSum(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += num;
            while (num != 0) {
                ans -= num % 10;
                num /= 10;
            }
        }
        return ans;
    }
}
