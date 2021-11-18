package suggestions.nth_divisible_by_at_least_one;

// given int[] arr and number k.
// find the k-th lowest positive number which is divisible by at least one number from arr
// it's guaranteed that ans is lower than Long.MAX_VALUE

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static long nthLowestDivisibleNumber(long[] arr, long k) {
        int n = arr.length;
        if (n == 1) return arr[0] * k;

        Arrays.sort(arr);
        int totalVariants = 1 << n;
        long[] lcm = new long[totalVariants];
        lcm[0] = 1;

        int divisorsToProcess = 0;
        for (int bit = 0, maskForBit = 1; bit < n; bit++, maskForBit <<= 1) {
            long num = arr[bit];
            if (num == 1) return k;

            boolean isDivisibleByOther = false;
            for (int j = 0; j < bit; j++) {
                if (num % arr[j] == 0) {
                    isDivisibleByOther = true;
                    break;
                }
            }
            if (isDivisibleByOther) continue;
            for (int subMask = divisorsToProcess; ; subMask = (subMask - 1) & divisorsToProcess) {
                lcm[subMask | maskForBit] = lcm(lcm[subMask], num);
                if (subMask == 0) break;
            }
            divisorsToProcess |= maskForBit;
        }


        HashMap<Long, Integer> map = new HashMap<>();
        int divisorsToCheck = 0;

        for (int subMask = divisorsToProcess; subMask != 0; subMask = (subMask - 1) & divisorsToProcess) {
            if (lcm[subMask] == 0) continue;
            if ((Integer.bitCount(subMask) & 1) == 1) {
                int newVal = map.compute(lcm[subMask], (key, v) -> v == null ? 1 : v + 1);
                if (newVal == 0) divisorsToCheck--;
                if (newVal == 1) divisorsToCheck++;
            } else {
                int newVal = map.compute(lcm[subMask], (key, v) -> v == null ? -1 : v - 1);
                if (newVal == 0) divisorsToCheck--;
                if (newVal == -1) divisorsToCheck++;
            }
        }

        long[][] divisors = new long[divisorsToCheck][2];
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) continue;
            divisors[--divisorsToCheck][0] = entry.getKey();
            divisors[divisorsToCheck][1] = entry.getValue();
        }
        Arrays.sort(divisors, Comparator.comparingLong(x -> x[0]));

        long lo = 1L, hi = Long.MAX_VALUE;
        if (divisors[0][0] < Long.MAX_VALUE / k) hi = k * divisors[0][0];
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long tmp = 0;
            for (long[] divisor : divisors) {
                if (divisor[0] > mid) break;
                tmp += mid / divisor[0] * divisor[1];
            }
            if (tmp < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    //greatest common divisor
    private static long gcd(long a, long b) {
        long c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    //least common multiplier
    static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0L;
        a /= gcd(a, b);
        if (Long.MAX_VALUE / a < b) return 0L;
        return a * b;
    }
}
