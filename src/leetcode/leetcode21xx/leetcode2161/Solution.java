package leetcode.leetcode21xx.leetcode2161;

import java.util.Arrays;

public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int countLess = 0, countEqual = 0;
        for (int num : nums) {
            if (num < pivot) countLess++;
            else if (num == pivot) countEqual++;
        }

        int[] ans = new int[nums.length];
        Arrays.fill(ans, countLess, countLess + countEqual, pivot);
        int i1 = 0, i2 = countLess + countEqual;
        for (int num : nums) {
            if (num < pivot) ans[i1++] = num;
            else if (num > pivot) ans[i2++] = num;
        }
        return ans;
    }
}
