package basic;

import basic.tuples.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IntegerUtils {
    public static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }

    public static Collection<Long> getPrimeDivisors(long x) {
        ArrayList<Long> primes = new ArrayList<>();
        int limit = (int) Math.sqrt(x);
        for (int i = 2; i <= limit; i++) {
            if (x % i == 0) {
                primes.add((long) i);
                while (x % i == 0) {
                    x /= i;
                    limit = (int) Math.sqrt(x);
                }
            }
        }
        if (x > 1) primes.add(x);
        return primes;
    }

    public static List<Pair<Long, Integer>> getFactorization(long x) {
        ArrayList<Pair<Long, Integer>> primes = new ArrayList<>();
        int limit = (int) Math.sqrt(x);
        for (int i = 2; i <= limit; i++) {
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
}
