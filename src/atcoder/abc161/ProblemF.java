package atcoder.abc161;

import java.math.BigInteger;
import java.util.*;

public class ProblemF {
    private static final int[] firstPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    private static final int nextPrime = 101;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if (n == 2) {
            System.out.println(1);
            return;
        }
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        set.add(n - 1);
        BigInteger b1 = BigInteger.valueOf(n);
        boolean isPrime1 = b1.isProbablePrime(100);
        if (!isPrime1) {
            List<Pair<Long, Integer>> factorization = getFactorization(n);
            LinkedList<Long> factors = new LinkedList<>();
            allFactors(0, 1, factorization, factors);
            for (Long factor : factors) {
                long tmp = n;
                if (factor == 1L || factor == n) continue;
                while (tmp % factor == 0L) tmp /= factor;
                if (tmp % factor == 1L) set.add(factor);
            }
        }
        BigInteger b2 = BigInteger.valueOf(n - 1);
        boolean isPrime2 = b2.isProbablePrime(100);
        if (!isPrime2) {
            List<Pair<Long, Integer>> factorization = getFactorization(n - 1);
            LinkedList<Long> factors = new LinkedList<>();
            allFactors(0, 1, factorization, factors);
            set.addAll(factors);
        }
        System.out.println(set.size());
    }

    public static List<Pair<Long, Integer>> getFactorization(long x) {
        ArrayList<Pair<Long, Integer>> primes = new ArrayList<>();
        int limit = (int) Math.sqrt(x);
        for (int i = 0; i < firstPrimes.length; i++) {
            int prime = firstPrimes[i];
            if (x % prime == 0) {
                x /= prime;
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

    private static void allFactors(int i, long tmp, List<Pair<Long, Integer>> pairs, List<Long> res) {
        if (pairs.size() == i) {
            res.add(tmp);
        } else {
            Pair<Long, Integer> pair = pairs.get(i);
            allFactors(i + 1, tmp, pairs, res);
            for (int j = 1; j <= pair.getB(); j++) {
                tmp *= pair.getA();
                allFactors(i + 1, tmp, pairs, res);
            }
        }
    }

    private static class Pair<A, B> {
        private final A a;
        private final B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(a, pair.a) &&
                    Objects.equals(b, pair.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        public A getA() {
            return a;
        }

        public B getB() {
            return b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}
