package leetcode.leetcode23xx.leetcode2338;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    private static final int maxDifferentPrimeFactors = 5, maxTotalFactors = 13, p = 1_000_000_007;
    private static final int[] firstPrimes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
    };

    private static int[] factorPowers(int n) {
        int[] powers = new int[maxDifferentPrimeFactors];
        int numberOfPrimeFactors = 0;
        for (int prime : firstPrimes) {
            if (prime * prime > n) break;
            int c = 0;
            while (n % prime == 0) {
                c++;
                n /= prime;
            }
            if (c != 0) powers[numberOfPrimeFactors++] = c;
        }
        if (n != 1) powers[numberOfPrimeFactors] = 1;
        return powers;
    }

    private static int numberOfSequencesOfLength(int[] arr, int k, Map<FactorPowers, Integer> cache) {
        if (k <= 1) return 1;
        Arrays.sort(arr);
        FactorPowers key = new FactorPowers(arr, k);
        Integer val = cache.get(key);
        if (val == null) {
            val = 0;
            for (int a = 0; a <= arr[0]; a++) {
                for (int b = 0; b <= arr[1]; b++) {
                    for (int c = 0; c <= arr[2]; c++) {
                        for (int d = 0; d <= arr[3]; d++) {
                            for (int e = 0; e <= arr[4]; e++) {
                                if (a == arr[0] && b == arr[1] && c == arr[2] && d == arr[3] && e == arr[4]) continue;
                                val += numberOfSequencesOfLength(new int[]{a, b, c, d, e}, k - 1, cache);
                                if (val >= p) val -= p;
                            }
                        }
                    }
                }
            }
            cache.put(key, val);
        }
        return val;
    }

    private static int reverse(int a) {
        int t = 0, newT = 1, r = p, newR = a, q, tmp;
        while (newR != 0) {
            q = r / newR;
            tmp = t - q * newT;
            t = newT;
            newT = tmp;
            tmp = r - q * newR;
            r = newR;
            newR = tmp;
        }
        if (r > 1) return -1;
        if (t < 0) t += p;
        return t;
    }

    public int idealArrays(int n, int maxValue) {
        int maxSeqLength = Math.min(maxTotalFactors + 1, n);
        long[] mult = new long[maxSeqLength + 1];
        mult[0] = 1;
        mult[1] = 1;
        for (int i = 2, j = n - 1; i <= maxSeqLength; i++, j--) mult[i] = mult[i - 1] * j % p * reverse(i - 1) % p;

        Map<FactorPowers, Integer> cache = new HashMap<>();
        long ans = 0;
        for (int i = 1; i <= maxValue; i++) {
            int[] factorPowers = factorPowers(i);
            int totalPower = 0;
            for (int factorPower : factorPowers) totalPower += factorPower;
            for (int j = Math.min(totalPower + 1, maxSeqLength); j >= 1; j--) {
                ans += numberOfSequencesOfLength(factorPowers.clone(), j, cache) * mult[j];
                if (ans >= p) ans %= p;
            }
        }
        return (int) ans;
    }

    private record FactorPowers(int[] arr, int k) {
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (FactorPowers) obj;
            return Arrays.equals(this.arr, that.arr) &&
                    this.k == that.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(Arrays.hashCode(arr), k);
        }
    }
}
