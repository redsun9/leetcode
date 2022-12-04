package help_requests.stock_exchange;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] prices = {2, 3, 4};
        assertEquals(9, Solution.getMaximumEarn(prices, 5));
    }

    @Test
    void test2() {
        int[] prices = {4, 5, 6, 7};
        assertEquals(16, Solution.getMaximumEarn(prices, 10));
    }

    @Test
    void test3() {
        int[] prices = {4, 6, 3, 7};
        assertEquals(30, Solution.getMaximumEarn(prices, 10));
    }

    @Test
    void test4() {
        int[] prices = {4, 7, 5, 6};
        assertEquals(19, Solution.getMaximumEarn(prices, 10));
    }

    @Test
    void test5() {
        int[] prices = {4, 3, 2, 1};
        assertEquals(10, Solution.getMaximumEarn(prices, 10));
    }

    @Test
    void testReverse1() {
        int[] prices = {1, 3, 5, 9};
        assertEquals(2, Solution.getMinimumToEarn(prices, 16));
    }

    @Test
    void testCorrectness() throws InterruptedException {
        int n = 20, maxPrice = 100;
        long minAmount = 1, maxAmount = 100;
        assertTrue(StressTester.exactStressTest(
                seed -> generate(seed, n, maxPrice, minAmount, maxAmount),
                data -> Solution.getMaximumEarn(data.prices, data.amount),
                data -> Solution.getMaximumEarn2(data.prices, data.amount),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testCorrectnessReverse() throws InterruptedException {
        int n = 20, maxPrice = 100;
        long minAmount = 1, maxAmount = Long.MAX_VALUE;
        assertTrue(StressTester.exactStressTest(
                seed -> generate(seed, n, maxPrice, minAmount, maxAmount),
                data -> Solution.getMinimumToEarn(data.prices, data.amount),
                data -> Solution.getMinimumToEarn2(data.prices, data.amount),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testReverse() throws InterruptedException {
        int n = 100, maxPrice = 1000;
        long minAmount = 1, maxAmount = Long.MAX_VALUE;
        assertTrue(StressTester.constructionStressTest(
                seed -> generate(seed, n, maxPrice, minAmount, maxAmount),
                data -> Solution.getMinimumToEarn(data.prices, data.amount),
                (data, answer) -> data.amount <= Solution.getMaximumEarn(data.prices, answer) &&
                        data.amount > Solution.getMaximumEarn(data.prices, answer - 1)
                ,
                1_000_000,
                1,
                100_000
        ));
    }

    private static TestData generate(long seed, int n, int maxPrice, long minAmount, long maxAmount) {
        Random random = new Random(seed);
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) prices[i] = 1 + random.nextInt(maxPrice);
        long amount = minAmount + random.nextLong(maxAmount - minAmount + 1);
        return new TestData(prices, amount);
    }

    private record TestData(int[] prices, long amount) {
        @Override
        public String toString() {
            return "TestData{" + "prices=" + Arrays.toString(prices) + ", amount=" + amount + '}';
        }
    }
}