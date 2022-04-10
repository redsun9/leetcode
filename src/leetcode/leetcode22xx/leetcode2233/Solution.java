package leetcode.leetcode22xx.leetcode2233;

import java.util.Arrays;

public class Solution {
    private static final int p = 1_000_000_007;

    public int maximumProduct(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = 1, cur = 0, n = nums.length;
        while (idx < n && k >= cur + (long) idx * (nums[idx] - nums[idx - 1])) {
            cur += idx * (nums[idx] - nums[idx - 1]);
            idx++;
        }

        // ans  = a^b * (a+1)^c *  product(nums[idx,n))
        k -= cur;
        int a = nums[idx - 1] + k / idx;
        int c = k % idx;
        int b = idx - c;
        long ans = (long) powMod(a, b) * powMod(a + 1, c) % p;
        for (int i = idx; i < n; i++) {
            ans = ans * nums[i];
            if (ans >= p) ans %= p;
        }

        return (int) ans;
    }

    private static int powMod(int a, int b) {
        long res = 1;
        while (b != 0)
            if ((b & 1) != 0) {
                res = (res * a) % p;
                --b;
            } else {
                a = (int) (((long) a * a) % p);
                b >>= 1;
            }
        return (int) res;
    }
}
