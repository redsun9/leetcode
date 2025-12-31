package leetcode.leetcode37xx.leetcode3769;

import java.util.Arrays;

public class Solution {
    public int[] sortByReflection(int[] nums) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = myReverse(nums[i]);
            arr[i][1] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];

        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i][1];
        }
        return nums;
    }

    private static int myReverse(int num) {
        num = Integer.reverse(num);
        if ((num & 0xFFFF) == 0) num >>>= 16;
        if ((num & 0xFF) == 0) num >>>= 8;
        if ((num & 0xF) == 0) num >>>= 4;
        if ((num & 3) == 0) num >>>= 2;
        if ((num & 1) == 0) num >>>= 1;
        return num;
    }
}
