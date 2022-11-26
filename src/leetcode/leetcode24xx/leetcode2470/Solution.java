package leetcode.leetcode24xx.leetcode2470;

public class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            long lcm = 1;
            int j = i;
            while (lcm <= k && j < n && k % nums[j] == 0) {
                lcm = lcm * nums[j] / gcd(lcm, nums[j++]);
                if (lcm == k) ans++;
            }
        }
        return ans;
    }

    private static long gcd(long a, long b) {
        long c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
