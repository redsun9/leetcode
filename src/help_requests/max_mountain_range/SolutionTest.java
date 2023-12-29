package help_requests.max_mountain_range;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private static final int n = 10;
    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 10;

    @Test
    void test1() {
        assertEquals(18L, Solution.maxHeightSum(new int[]{3, 2, 5, 5, 2, 3}));
    }

    @Test
    void test2() {
        assertEquals(5L, Solution.maxHeightSum(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    void test3() {
        assertEquals(8L, Solution.maxHeightSum(new int[]{4, 1, 2, 1, 3}));
    }

    @Test
    void test4() {
        assertEquals(8L, Solution.maxHeightSum(new int[]{3, 1, 4, 1, 2}));
    }

    @Test
    void test5() {
        assertEquals(8L, Solution.maxHeightSum(new int[]{3, 1, 2, 1, 4}));
    }

    @Test
    void randomTest() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                SolutionTest::generate,
                DummySolution::maxHeightSum,
                Solution::maxHeightSum,
                1_000_000,
                1,
                100_000
        ));
    }


    private static int[] generate(long seed) {
        int[] arr = new int[n];
        Random random = new Random(seed);
        for (int i = 0; i < n; i++) arr[i] = random.nextInt(MIN_VAL, MAX_VAL);
        return arr;
    }
}