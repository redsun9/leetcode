package leetcode.leetcode21xx.leetcode2160;

import java.util.Arrays;

public class Solution {
    public int minimumSum(int num) {
        int[] a = {num / 1000, num / 100 % 10, num / 10 % 10, num % 10};
        Arrays.sort(a);
        return (a[0] + a[1]) * 10 + a[2] + a[3];
    }
}
