package leetcode.leetcode15xx.leetcode1569;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
    private static final int p = 1_000_000_007;
    private static final BigInteger bigP = BigInteger.valueOf(p);

    public int numOfWays(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 0;
        long[] fact = new long[n];
        long[] rFact = new long[n];
        fact[0] = 1;
        rFact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = fact[i - 1] * i % p;
        for (int i = 1; i < n; i++) rFact[i] = BigInteger.valueOf(fact[i]).modInverse(bigP).longValue();

        int[] left = new int[n]; // min value in subtree
        int[] right = new int[n]; // max value in subtree
        Arrays.fill(right, n - 1);
        long ans = 1;
        for (int num : nums) {
            num--;
            if (left[num] != right[num]) {
                long c = fact[right[num] - left[num]] * rFact[num - left[num]] % p * rFact[right[num] - num] % p;
                ans = ans * c % p;
                for (int i = left[num]; i < num; i++) right[i] = num - 1;
                for (int i = right[num]; i > num; i--) left[i] = num + 1;
            }
        }
        return (int) (ans - 1);
    }
}
