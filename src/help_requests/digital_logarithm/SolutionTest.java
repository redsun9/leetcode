package help_requests.digital_logarithm;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private static final int N = 1_000;
    private static final int MIN_VAL = 1;
    private static final int MAX_VAl = 1_000_000_000;

    @Test
    void testCorrectness() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    int[][] testData = new int[2][N];
                    for (int i = 0; i < N; i++) {
                        testData[0][i] = MIN_VAL + random.nextInt(MAX_VAl - MIN_VAL);
                        testData[1][i] = MIN_VAL + random.nextInt(MAX_VAl - MIN_VAL);
                    }
                    return testData;
                },
                testData -> Solution.solveWithHashMap(testData[0], testData[1]),
                testData -> Solution.solveWithPriorityQueue(testData[0], testData[1]),
                1_000_000,
                1,
                10_000
        ));
    }

    @Test
    void testF2() {
        for (int i = 1; i < MAX_VAl; i++) {
            int expected = Solution.f1(i);
            int actual = Solution.f2(i);
            assertEquals(expected, actual);
        }
    }

    @Test
    void testF3() {
        for (int i = 1; i < MAX_VAl; i++) {
            int expected = Solution.f1(i);
            int actual = Solution.f3(i);
            assertEquals(expected, actual);
        }
    }
}