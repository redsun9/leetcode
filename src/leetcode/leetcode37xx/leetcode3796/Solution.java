package leetcode.leetcode37xx.leetcode3796;

import java.util.Arrays;

public class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for (int[] restriction : restrictions) arr[restriction[0]] = restriction[1];
        for (int i = 1; i < n; i++) arr[i] = Math.min(arr[i], arr[i - 1] + diff[i - 1]);
        int ans = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            arr[i] = Math.min(arr[i], arr[i + 1] + diff[i]);
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }
}
