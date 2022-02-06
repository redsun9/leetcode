package leetcode.leetcode21xx.leetcode2149;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, i1 = 0, i2 = 0; i < n; ) {
            while (nums[i1] < 0) i1++;
            ans[i++] = nums[i1++];
            while (nums[i2] > 0) i2++;
            ans[i++] = nums[i2++];
        }
        return ans;
    }
}
