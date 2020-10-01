package leetcode.leetcode13xx.leetcode1300;

import java.util.Arrays;

//iterative on sorted array
public class Solution2 {
    public int findBestValue(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int i = 0;
        while (i < n && target > arr[i] * (n - i)) target -= arr[i++];
        if (i == n) return arr[n - 1];
        int a = target / (n - i);
        int b = (target + n - i - 1) / (n - i);
        if (target - a * (n - i) <= b * (n - i) - target) return a;
        else return b;
    }
}
