package leetcode.leetcode11xx.leetcode1175;

import java.util.Arrays;

public class Solution {
    public static final int p = 1_000_000_007;

    private static final int[] firstPrimes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
    };

    public int numPrimeArrangements(int n) {
        int pos = Arrays.binarySearch(firstPrimes, n);
        if (pos < 0) pos = -pos - 1;
        else pos = pos + 1;

        long ans = 1;
        for (int i = 2; i <= pos; i++) ans = ans * i % p;
        for (int i = 2; i <= n - pos; i++) ans = ans * i % p;
        return (int) ans;
    }
}
