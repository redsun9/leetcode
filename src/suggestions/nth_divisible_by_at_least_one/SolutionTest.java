package suggestions.nth_divisible_by_at_least_one;

import org.junit.jupiter.api.Test;
import prng.XorShiftN;
import stress.StressTester;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings({"ConstantConditions", "DuplicatedCode"})
class SolutionTest {
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
    private static final int[] nonPrimes = {4, 6, 8, 9, 10, 12, 14, 15};
    private static final int[] only235 = {2, 3, 5, 4, 9, 25, 6, 10, 15, 30};

    @Test
    void testPrimes() {
        XorShiftN random = new XorShiftN(1, primes.length);
        int numberOfTests = 100;
        int[] masks = new int[numberOfTests];
        for (int i = 0; i < numberOfTests; i++) masks[i] = random.nextInteger();

        int maxK = 1000;
        IntStream.range(0, numberOfTests).parallel().forEach(t -> dumbCheck(primes, masks[t], maxK));
    }

    @Test
    void testNonPrimes() {
        XorShiftN random = new XorShiftN(1, nonPrimes.length);
        int numberOfTests = 100;
        int[] masks = new int[numberOfTests];
        for (int i = 0; i < numberOfTests; i++) masks[i] = random.nextInteger();

        int maxK = 1000;
        IntStream.range(0, numberOfTests).parallel().forEach(t -> dumbCheck(nonPrimes, masks[t], maxK));
    }

    @Test
    void test235() {
        XorShiftN random = new XorShiftN(1, only235.length);
        int numberOfTests = 100;
        int[] masks = new int[numberOfTests];
        for (int i = 0; i < numberOfTests; i++) masks[i] = random.nextInteger();

        int maxK = 1000;
        IntStream.range(0, numberOfTests).parallel().forEach(t -> dumbCheck(only235, masks[t], maxK));
    }

    @Test
    void test2() throws InterruptedException {
        long minVal = 10_000_000L, maxVal = Long.MAX_VALUE, diff = maxVal - minVal + 1;

        assertTrue(StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    long a = 2 + random.nextLong(1_000_000);
                    long b = 2 + random.nextLong(1_000_000);
                    long expected = minVal + random.nextLong(diff);
                    expected -= Math.min(expected % a, expected % b);
                    long k = expected / a + expected / b;
                    long lcm = Solution.lcm(a, b);
                    if (lcm != 0) k -= expected / lcm;
                    return new TestData(new long[]{a, b}, k, expected);
                },
                x -> x.expected,
                x -> Solution.nthLowestDivisibleNumber(x.arr, x.k),
                10_000
        ));
    }

    @Test
    void test3() throws InterruptedException {
        long minVal = 10_000_000L, maxVal = Long.MAX_VALUE, diff = maxVal - minVal + 1;
        assertTrue(StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    long a = 2 + random.nextLong(1_000_000);
                    long b = 2 + random.nextLong(1_000_000);
                    long c = 2 + random.nextLong(1_000_000);
                    long expected = minVal + random.nextLong(diff);
                    expected -= Math.min(expected % c, Math.min(expected % a, expected % b));
                    long k = expected / a + expected / b + expected / c;

                    long lcmAB = Solution.lcm(a, b);
                    if (lcmAB != 0) k -= expected / lcmAB;

                    long lcmAC = Solution.lcm(a, c);
                    if (lcmAC != 0) k -= expected / lcmAC;

                    long lcmBC = Solution.lcm(b, c);
                    if (lcmBC != 0) k -= expected / lcmBC;

                    long lcmABC = Solution.lcm(lcmAB, c);
                    if (lcmABC != 0) k += expected / lcmABC;
                    return new TestData(new long[]{a, b, c}, k, expected);
                },
                x -> x.expected,
                x -> Solution.nthLowestDivisibleNumber(x.arr, x.k),
                10_000
        ));
    }

    private static void dumbCheck(int[] a, int mask, int maxK) {
        long[] arr = new long[Integer.bitCount(mask)];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0, pos = 0; i < a.length; i++) {
            if ((mask >>> i & 1) == 1) {
                arr[pos] = a[i];
                pq.offer(arr[pos++]);
            }
        }

        long k = 1, previous = 0;
        while (true) {
            long expected = pq.poll();
            if (previous == expected) continue;
            for (long p : arr) if (expected % p == 0) pq.offer(expected + p);
            previous = expected;
            long actual = Solution.nthLowestDivisibleNumber(arr, k);
            assertEquals(expected, actual);
            if (k++ == maxK) break;
        }
    }


    private static class TestData {
        long[] arr;
        long k, expected;

        @Override
        public String toString() {
            return "TestData{" +
                    "arr=" + Arrays.toString(arr) +
                    ", k=" + k +
                    ", expected=" + expected +
                    '}';
        }

        public TestData(long[] arr, long k, long expected) {
            this.arr = arr;
            this.k = k;
            this.expected = expected;
        }
    }
}