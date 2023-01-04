package codeforces.contest1731;

import java.util.Scanner;

public class ProblemE {
    private static final int MAX_N = 1_000_000;
    private static final int[] firstPrimes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
            127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
            179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
            233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
            283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
            353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
            419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
            467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
            547, 557, 563, 569, 571, 577, 587, 593, 599, 601,
            607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
            661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
            739, 743, 751, 757, 761, 769, 773, 787, 797, 809,
            811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
            877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
            947, 953, 967, 971, 977, 983, 991, 997
    };

    private static final long[] COPRIME_COUNT = generate(MAX_N);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            long m = scanner.nextLong();
            long ans = solve(n, m);
            System.out.println(ans);
        }
    }

    public static long solve(int n, long m) {
        long ans = 0;
        for (int gcd = n / 2; gcd >= 2; gcd--) {
            long took = Math.min(COPRIME_COUNT[n / gcd], m) / (gcd - 1) * (gcd - 1);
            ans += took / (gcd - 1) * gcd;
            m -= took;
            if (m == 0) return ans;
        }
        return -1;
    }

    private static long[] generate(int n) {
        int[] nums = new int[n + 1];
        long[] coprimes = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            nums[i] = i;
            coprimes[i] = i;
        }
        coprimes[1] = 0;
        for (int prime : firstPrimes) {
            for (int i = prime; i < n; i += prime) {
                while (nums[i] % prime == 0) nums[i] /= prime;
                coprimes[i] = coprimes[i] / prime * (prime - 1);
            }
        }
        for (int prime = 1009; prime <= n; prime++) {
            if (nums[prime] == 1) continue;
            for (int i = prime; i < n; i += prime) {
                while (nums[i] % prime == 0) nums[i] /= prime;
                coprimes[i] = coprimes[i] / prime * (prime - 1);
            }
        }
        for (int i = 0; i < n; i++) coprimes[i + 1] += coprimes[i];
        return coprimes;
    }
}
