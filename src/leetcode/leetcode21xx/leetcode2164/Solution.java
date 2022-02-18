package leetcode.leetcode21xx.leetcode2164;

import java.util.Arrays;

public class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        if (n <= 2) return nums;
        int[] tmp = new int[n];
        for (int i1 = 0, i2 = 0; i1 < n; i1 += 2, i2++) tmp[i2] = nums[i1];
        for (int i1 = 1, i2 = (n + 1) / 2; i1 < n; i1 += 2, i2++) tmp[i2] = -nums[i1];
        Arrays.sort(tmp, 0, (n + 1) / 2);
        Arrays.sort(tmp, (n + 1) / 2, n);
        for (int i1 = 0, i2 = 0; i1 < n; i1 += 2, i2++) nums[i1] = tmp[i2];
        for (int i1 = 1, i2 = (n + 1) / 2; i1 < n; i1 += 2, i2++) nums[i1] = -tmp[i2];
        return nums;
    }
}
