package leetcode.leetcode1xx.leetcode179;

import java.util.Arrays;

// sort by comparator ab vs ba
public class Solution {
    public String largestNumber(int[] nums) {
        boolean nonZeroExists = false;
        for (int num : nums) {
            if (num != 0) {
                nonZeroExists = true;
                break;
            }
        }
        if (!nonZeroExists) return "0";
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
}
