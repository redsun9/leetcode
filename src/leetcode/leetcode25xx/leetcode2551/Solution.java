package leetcode.leetcode25xx.leetcode2551;

import java.util.Arrays;

public class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) arr[i] = weights[i + 1] + weights[i];
        Arrays.sort(arr);
        long ans = 0;
        for (int i = 1, i1 = 0, i2 = n - 2; i < k; i++, i1++, i2--) ans += arr[i2] - arr[i1];
        return ans;
    }
}
