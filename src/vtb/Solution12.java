package vtb;

import java.util.List;

// number of non empty subarray which sums are divisible by k
public class Solution12 {
    public static int numSubarrays(List<Integer> a, int k) {
        // Напишите ваш код здесь...
        int ans = 0;
        int[] dp = new int[k];
        dp[0] = 1;
        int sum = 0;
        for (int num : a) {
            sum = (sum + num) % k;
            if (sum < 0) sum += k;
            ans += dp[sum];
            dp[sum]++;
        }
        return ans;
    }
}
