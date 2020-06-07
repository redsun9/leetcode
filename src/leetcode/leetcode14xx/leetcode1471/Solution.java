package leetcode.leetcode14xx.leetcode1471;

import java.util.Arrays;

public class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        int median = arr[(arr.length - 1) / 2];
        int i1 = 0, i2 = arr.length - 1;
        for (int i = 0; i < k; i++) {
            if ((median - arr[i1]) - (arr[i2] - median) > 0) ans[i] = arr[i1++];
            else ans[i] = arr[i2--];
        }
        return ans;
    }
}
