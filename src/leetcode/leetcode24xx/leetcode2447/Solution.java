package leetcode.leetcode24xx.leetcode2447;

public class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int gcd = nums[i], j = i + 1;
            if (gcd == k) ans++;
            while (gcd >= k && j < n) {
                gcd = gcd(gcd, nums[j++]);
                if (gcd == k) ans++;
            }
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
