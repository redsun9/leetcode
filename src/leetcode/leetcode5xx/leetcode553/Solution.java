package leetcode.leetcode5xx.leetcode553;

public class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        if (n > 1) sb.append('/');
        if (n > 2) sb.append('(');
        if (n > 1) sb.append(nums[1]);
        for (int i = 2; i < n; i++) sb.append('/').append(nums[i]);
        if (n > 2) sb.append(')');
        return sb.toString();
    }
}
