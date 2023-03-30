package help_requests.subarrays_with_sum_and_zero;

public class Solution {
    public static long countInterestingSubarrays(int[] arr, long threshold) {
        long ans = 0, sum = 0;
        for (int l = 0, r = 0, n = arr.length, zeros = 0; r < n; r++) {
            sum += arr[r];
            if (arr[r] == 0) zeros++;
            while (sum > threshold || zeros > 1) {
                sum -= arr[l];
                if (arr[l] == 0) zeros--;
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
