package leetcode.leetcode22xx.leetcode2281;

import java.util.Stack;

// O(N) - time and space complexity
public class Solution {
    private static final int MOD = 1_000_000_007;

    public int totalStrength(int[] a) {
        int n = a.length;
        int[] left = new int[n], right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && a[stack.peek()] > a[i]) stack.pop();
            if (stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && a[stack.peek()] >= a[i]) stack.pop();
            if (stack.isEmpty()) right[i] = n;
            else right[i] = stack.peek();
            stack.push(i);
        }

        long[] prefSum = new long[n + 1]; // sum_{j=0}^{j=i-1} a[j]
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += a[i];
            if (sum >= MOD) sum -= MOD;
            prefSum[i + 1] = sum;
        }

        long[] prefSum2 = new long[n + 1]; // sum_{j=0}^{j=i-1} a[j]*j
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) a[i] * i;
            if (sum >= MOD) sum %= MOD;
            prefSum2[i + 1] = sum;
        }

        long ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = left[i], r = right[i];
            long ai = a[i];
            long tmp = ai * (i - l) % MOD * (r - i) % MOD;
            tmp += (r - i) * ((prefSum2[i] - prefSum2[l + 1]) - l * (prefSum[i] - prefSum[l + 1]) % MOD) % MOD;
            tmp -= (i - l) * ((prefSum2[r] - prefSum2[i + 1]) - r * (prefSum[r] - prefSum[i + 1]) % MOD) % MOD;
            tmp %= MOD;
            if (tmp < 0) tmp += MOD;
            ans += ai * tmp % MOD;
            if (ans >= MOD) ans -= MOD;
        }
        return (int) ans;
    }
}
