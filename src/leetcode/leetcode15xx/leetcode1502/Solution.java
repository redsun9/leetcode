package leetcode.leetcode15xx.leetcode1502;

import java.util.Arrays;

public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        if (n <= 2) return true;
        Arrays.sort(arr);
        int a = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != a) return false;
        }
        return true;
    }
}
