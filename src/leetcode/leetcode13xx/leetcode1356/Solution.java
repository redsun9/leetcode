package leetcode.leetcode13xx.leetcode1356;

import java.util.Arrays;

public class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            arr[i] = (Integer.bitCount(a) << 16) + a;
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            arr[i] &= 0xffff;
        }
        return arr;
    }
}
