package leetcode.leetcode16xx.leetcode1619;

import java.util.Arrays;

public class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int start = n / 20;
        int end = n - start;
        int sum = 0;
        for (int i = start; i < end; i++) sum += arr[i];
        return sum / ((double) n - 2 * start);
    }
}
