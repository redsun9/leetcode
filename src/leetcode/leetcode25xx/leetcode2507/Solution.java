package leetcode.leetcode25xx.leetcode2507;

public class Solution {
    private static final int[] firstPrimes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
            127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
            179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
            233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
            283, 293, 307, 311, 313
    };

    public int smallestValue(int n) {
        int ans = n;
        int slow = n, fast = n;
        do {
            slow = f(slow);
            fast = f(fast);
            ans = Math.min(ans, fast);
            fast = f(fast);
            ans = Math.min(ans, fast);
        } while (slow != fast);
        return ans;
    }

    private static int f(int n) {
        int ans = 0;
        for (int prime : firstPrimes) {
            while (n % prime == 0) {
                ans += prime;
                n /= prime;
            }
            if (prime * prime > n) break;
        }

        if (n != 1) ans += n;
        return ans;
    }
}
