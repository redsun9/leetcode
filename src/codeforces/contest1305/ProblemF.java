package codeforces.contest1305;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class ProblemF {
    private static final int TRY_MAX = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        shuffleArray(a);
        //сперва посчитаем для 2 и 3
        HashSet<Long> checked = new HashSet<>();
        long count2 = greedyCount(a, 2, n + 1);
        long count3 = greedyCount(a, 3, n + 1);
        int currentMin = (int) count2;
        if (count3 >= 0 && count3 < count2) {
            currentMin = (int) count3;
        }
        checked.add(2L);
        checked.add(3L);
        int currentTry = 0;
        final int maxTry = Math.min(TRY_MAX, n);
        while (currentMin != 0 && currentTry < maxTry) {
            for (int i = -1; i <= 1; i++) {
                ArrayList<Long> primes = factorization(a[currentTry] + i);
                for (long prime : primes) {
                    if (checked.add(prime)) {
                        long greedyCount = greedyCount(a, prime, currentMin);
                        if (greedyCount >= 0 && greedyCount < currentMin) {
                            currentMin = (int) greedyCount;
                            if (currentMin == 0) {
                                System.out.println(0);
                                return;
                            }
                        }
                    }
                }
            }
            currentTry++;
        }
        System.out.println(currentMin);
    }

    public static ArrayList<Long> factorization(long x) {
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

    public static long greedyCount(long[] a, long p, int stopValue) {
        int n = a.length;
        long result = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < p) result += (p - a[i]);
            else {
                long remainder = a[i] % p;
                result += Math.min(remainder, p - remainder);
            }
            if (stopValue <= result) return -1;
        }
        return result;
    }

    public static <T> void shuffleArray(T[] array) {
        Random random = new Random();
        int n = array.length;
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            T tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    public static void shuffleArray(long[] array) {
        Random random = new Random();
        int n = array.length;
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            long tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
}
