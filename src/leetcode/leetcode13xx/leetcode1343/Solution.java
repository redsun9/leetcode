package leetcode.leetcode13xx.leetcode1343;

public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        if (n < k) return 0;
        int thresholdSum = k * threshold;
        int tmp = 0;
        for (int i = 0; i < k; i++) {
            tmp += arr[i];
        }
        int ans = 0;
        if (tmp >= thresholdSum) ans++;
        for (int i = k, j = 0; i < n; i++, j++) {
            tmp = tmp + arr[i] - arr[j];
            if (tmp >= thresholdSum) ans++;
        }
        return ans;
    }
}
