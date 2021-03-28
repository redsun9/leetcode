package leetcode.leetcode17xx.leetcode1735;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int MAX_VAL = 10_000;
    private static final int MAX_CONSIDER = MAX_VAL + 20;


    private static final int p = 1_000_000_007;
    private static final BigInteger bigP = BigInteger.valueOf(p);
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    private static final int primeLength = primes.length;

    private static List<Integer> factorizeOnlyPowers(int n) {
        List<Integer> ans = new ArrayList<>();
        int pos = 0;
        while (pos < primeLength && n > primes[pos]) {
            int power = 0;
            while (n % primes[pos] == 0) {
                n /= primes[pos];
                power++;
            }
            if (power != 0) ans.add(power);
            pos++;
        }
        if (n != 1) ans.add(1);
        return ans;
    }

    public int[] waysToFillArray(int[][] queries) {
        int[] factors = new int[MAX_CONSIDER];
        int[] inverses = new int[MAX_CONSIDER];
        int[] reverseFactors = new int[MAX_CONSIDER];
        factors[0] = 1;
        reverseFactors[0] = 1;
        for (int i = 1; i < MAX_CONSIDER; i++) {
            factors[i] = (int) (factors[i - 1] * (long) i % p);
            inverses[i] = BigInteger.valueOf(i).modInverse(bigP).intValue();
            reverseFactors[i] = (int) (reverseFactors[i - 1] * (long) inverses[i] % p);
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int[] query = queries[i];
            List<Integer> powers = factorizeOnlyPowers(query[1]);
            int n = query[0];
            long tmp = 1;
            for (Integer power : powers) {
                tmp = tmp * factors[n + power - 1] % p * reverseFactors[n - 1] % p * reverseFactors[power] % p;
            }
            ans[i] = (int) tmp;
        }
        return ans;
    }
}
