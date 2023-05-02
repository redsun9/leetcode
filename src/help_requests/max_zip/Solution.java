package help_requests.max_zip;

// divide arr to maximum number of subarrays with sums between minThreshold and maxThreshold inclusively
public class Solution {
    public static int[] maxZip(int[] arr, int minThreshold, int maxThreshold) {
        if (minThreshold > maxThreshold) return null;
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int max = -1;
            long curSum = 0;
            for (int j = i; j >= 0; j--) {
                curSum += arr[j];
                if (curSum >= minThreshold && curSum <= maxThreshold) max = Math.max(max, dp[j]);
            }
            dp[i + 1] = max != -1 ? max + 1 : -1;
        }
        if (dp[n] == -1) return null;

        int ansLength = dp[n];
        int[] ans = new int[ansLength];

        while (ansLength-- > 0) {
            long curSum = 0;
            while (dp[n] != ansLength || curSum < minThreshold || curSum > maxThreshold) curSum += arr[--n];
            ans[ansLength] = (int) curSum;
        }
        return ans;
    }
}
