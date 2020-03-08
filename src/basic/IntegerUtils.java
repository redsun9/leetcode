package basic;

import basic.matrix.MatrixTools;
import basic.tuples.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IntegerUtils {
    private static final int[] firstPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    private static final int nextPrime = 101;

    public static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }

    public static Collection<Long> getPrimeDivisors(long x) {
        ArrayList<Long> primes = new ArrayList<>();
        int limit = (int) Math.sqrt(x);
        for (int i = 0; i < firstPrimes.length; i++) {
            int prime = firstPrimes[i];
            if (x % prime == 0) {
                primes.add((long) prime);
                while (x % prime == 0) {
                    x /= prime;
                }
                limit = (int) Math.sqrt(x);
            }
        }
        for (int i = nextPrime; i <= limit; i += 2) {
            if (x % i == 0) {
                primes.add((long) i);
                while (x % i == 0) {
                    x /= i;
                }
                limit = (int) Math.sqrt(x);
            }
        }
        if (x > 1) primes.add(x);
        return primes;
    }

    public static List<Pair<Long, Integer>> getFactorization(long x) {
        ArrayList<Pair<Long, Integer>> primes = new ArrayList<>();
        int limit = (int) Math.sqrt(x);
        for (int i = 0; i < firstPrimes.length; i++) {
            int prime = firstPrimes[i];
            if (x % prime == 0) {
                int c = 1;
                while (x % prime == 0) {
                    x /= prime;
                    c++;
                }
                primes.add(new Pair<>((long) prime, c));
                limit = (int) Math.sqrt(x);
            }
        }
        for (int i = nextPrime; i <= limit; i += 2) {
            if (x % i == 0) {
                x /= i;
                int c = 1;
                while (x % i == 0) {
                    x /= i;
                    c++;
                }
                primes.add(new Pair<>((long) i, c));
                limit = (int) Math.sqrt(x);
            }
        }
        if (x > 1) primes.add(new Pair<>(x, 1));
        return primes;
    }


    //number of integer between [1;n] which are coprime with n
    public static long eulerPhi(long n) {
        Collection<Long> primeDivisors = getPrimeDivisors(n);
        for (Long primeDivisor : primeDivisors) {
            n = n / primeDivisor * (primeDivisor - 1);
        }
        return n;
    }

    //a^n
    public static long binPow(int a, int n) {
        long res = 1;
        long tmp = a;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= tmp;
            tmp *= tmp;
            n >>= 1;
        }
        return res;
    }

    //greatest common divisor
    public static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    //least common multiplier
    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static int powMod(int a, int b, int m) {
        long res = 1;
        while (b != 0)
            if ((b & 1) != 0) {
                res = (res * a) % m;
                --b;
            } else {
                a = (a * a) % m;
                b >>= 1;
            }
        return (int) res;
    }

    //x(0)=a, x(1)=b, x(n) = c*x(n-1)+d*x(n-2)
    public static long recurrentSequence(int a, int b, int c, int d, int n) {
        if (n == 0) return a;
        if (n == 1) return b;
        long[][] matrix = {{c, 1}, {d, 0}};
        long[][] matrixPower = MatrixTools.matrixPower(matrix, n - 1);
        return b * matrixPower[0][0] + a * matrixPower[1][0];
    }

    // x[N] = sum_{i=0}^{k-1} x[N-k+i]*b[i]
    // x[i] = a[i], for i=0..k-1
    public static long recurrentSequence(int a[], int b[], int n) {
        int k = a.length;
        if (n < k) {
            return a[n];
        }
        long[][] matrix = new long[k][k];
        for (int i = 0; i < k; i++) {
            matrix[i][0] = b[i];
        }
        for (int i = 0; i < k - 1; i++) {
            matrix[i][i + 1] = 1;
        }
        long[][] matrixPower = MatrixTools.matrixPower(matrix, n - k + 1);
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += a[k - 1 - i] * matrixPower[i][0];
        }
        return ans;
    }
}
