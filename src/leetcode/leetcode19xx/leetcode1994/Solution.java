package leetcode.leetcode19xx.leetcode1994;

public class Solution {
    private static final int MAX_N = 30;
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static final int bits = primes.length;
    private static final int p = 1_000_000_007;
    private static final int TOTAL_MASK = (1 << bits) - 1;

    public int numberOfGoodSubsets(int[] nums) {
        int[] count = new int[MAX_N + 1];
        for (int num : nums) count[num]++;

        long[] dp = new long[TOTAL_MASK + 1];
        dp[0] = 1;
        for (int num = 2; num <= MAX_N; num++) {
            if (num % 4 == 0 || num % 9 == 0 || num == 25 || count[num] == 0) continue;

            int c = count[num];
            int mask = 0;
            for (int i = 0; i < bits; i++) if (num % primes[i] == 0) mask |= 1 << i;

            int subMask = TOTAL_MASK ^ mask;
            int tmp = subMask;
            while (true) {
                int to = tmp | mask;
                dp[to] = dp[to] + c * dp[tmp];
                if (dp[to] >= p) dp[to] %= p;
                if (tmp == 0) break;
                tmp = (tmp - 1) & subMask;
            }
        }
        int ans = 0;
        for (int i = 1; i <= TOTAL_MASK; i++) {
            ans += dp[i];
            if (ans >= p) ans -= p;
        }
        return (int) ((long) ans * pow2ModP(count[1]) % p);
    }

    private static int pow2ModP(int n) {
        int a = 2;
        long res = 1;
        while (n != 0)
            if ((n & 1) != 0) {
                res = (res * a) % p;
                --n;
            } else {
                a = (int) (((long) a * a) % p);
                n >>= 1;
            }
        return (int) res;
    }
}
