package leetcode.leetcode2xx.leetcode260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int t = 0;
        for (int num : nums) {
            t ^= num;
        }
        int check = 1;
        while ((t & check) == 0) check <<= 1;
        int[] ans = new int[2];
        for (int num : nums) {
            ans[(num & check) == check ? 1 : 0] ^= num;
        }
        return ans;
    }
}
