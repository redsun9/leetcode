package help_requests.two_bags;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private static final int n = 20, MAX_VAL = 3, k = 5, m = 10;

    @Test
    void test1() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generate(seed, false),
                arr -> Solution.dummyMaxSum(arr, k),
                arr -> Solution.maxSum(arr, k),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void test2() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generate(seed, true),
                arr -> Solution2.dummyMaxSum(arr, k),
                arr -> Solution2.maxSum(arr, k),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void test3() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generate(seed, true),
                Solution3::dummyMaxSum,
                Solution3::maxSum,
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void test4() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generate(seed, false),
                arr -> Solution4.dummyMaxSum(arr, k),
                arr -> Solution4.maxSum(arr, k),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void test5() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generate(seed, true),
                arr -> Solution5.dummyMaxSum(arr, k),
                arr -> Solution5.maxSum(arr, k),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void test6() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generate(seed, false),
                arr -> Solution6.dummyMaxSum(arr, m, k),
                arr -> Solution6.maxSum(arr, m, k),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void test7() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generate(seed, true),
                arr -> Solution7.dummyMaxSum(arr, m, k, true),
                arr -> Solution7.maxSum(arr, m, k, true),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void test7All() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generate(seed, true),
                arr -> Solution7.dummyMaxSum(arr, m, n, true),
                arr -> Solution7.maxSum(arr, m, n, true),
                1_000_000,
                1,
                100_000
        ));
    }

    private static int[] generate(long seed, boolean allowNegative) {
        int[] arr = new int[n];
        Random random = new Random(seed);
        int diff = allowNegative ? 2 * MAX_VAL + 1 : MAX_VAL;
        int minVal = allowNegative ? -MAX_VAL : 1;
        for (int i = 0; i < n; i++) arr[i] = minVal + random.nextInt(diff);
        return arr;
    }
}