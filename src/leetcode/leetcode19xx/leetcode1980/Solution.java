package leetcode.leetcode19xx.leetcode1980;

public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) ans[i] = (char) ('1' + '0' - nums[i].charAt(i));
        return new String(ans);
    }
}
