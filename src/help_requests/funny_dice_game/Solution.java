package help_requests.funny_dice_game;

import java.util.Arrays;

// n k-sided dices
// if multiplication of all dices have odd number of divisors, then player wins
// answer can be presented as p/q, return p * q^(-1) mod 1_000_000_007
// 3<=k<=20
public class Solution {
    private static final int p = 1_000_000_007;
    private static final int[] firstPrimes = {2, 3, 5, 7, 11, 13, 17, 19};
    private static final int[] numberOfPrimesFork = {0, 0, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 8, 8};

    public static int solve(int n, int k) {
        int[] masksForResultsOnDice = new int[k];
        for (int i = 0; i < k; i++) {
            int mask = 0, tmp = i + 1;
            for (int j = 0; j < numberOfPrimesFork[k]; j++) {
                while (tmp % firstPrimes[j] == 0) {
                    mask ^= 1 << j;
                    tmp /= firstPrimes[j];
                }
            }
            masksForResultsOnDice[i] = mask;
        }
        int[] prev = new int[1 << numberOfPrimesFork[k]], next = new int[1 << numberOfPrimesFork[k]], tmpArr;
        prev[0] = 1;

        for (int i = 0; i < n; i++) {
            Arrays.fill(next, 0);
            for (int j = 0; j < k; j++) {
                for (int maskFrom = 0; maskFrom < prev.length; maskFrom++) {
                    int maskTo = maskFrom ^ masksForResultsOnDice[j];
                    next[maskTo] += prev[maskFrom];
                    if (next[maskTo] >= p) next[maskTo] -= p;
                }
            }
            tmpArr = prev;
            prev = next;
            next = tmpArr;
        }
        final int reverseK = reverse(k);
        return (int) ((long) prev[0] * powMod(reverseK, n) % p);
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
