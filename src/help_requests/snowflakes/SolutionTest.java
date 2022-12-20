package help_requests.snowflakes;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {
    private static final int k = 6, MAX_VAL = 5, n = 1000;

    @Test
    void testRandom2() throws InterruptedException {
        StressTester.exactStressTest(
                SolutionTest::generate,
                Solution::allUnique,
                Solution2::allUnique,
                100_000,
                1,
                10_000
        );
    }

    @Test
    void testRandom3() throws InterruptedException {
        StressTester.exactStressTest(
                SolutionTest::generate,
                Solution::allUnique,
                Solution3::allUnique,
                100_000,
                1,
                10_000
        );
    }

    @Test
    void testRandom4() throws InterruptedException {
        StressTester.exactStressTest(
                SolutionTest::generate,
                Solution::allUnique,
                Solution4::allUnique,
                100_000,
                1,
                10_000
        );
    }

    @Test
    void testRandom5() throws InterruptedException {
        StressTester.exactStressTest(
                SolutionTest::generate,
                Solution::allUnique,
                Solution5::allUnique,
                100_000,
                1,
                10_000
        );
    }

    @Test
    void testRandom6() throws InterruptedException {
        StressTester.exactStressTest(
                SolutionTest::generate,
                Solution::allUnique,
                Solution6::allUnique,
                100_000,
                1,
                10_000
        );
    }

    private static int[][] generate(long seed) {
        Random random = new Random(seed);
        int[][] flakes = new int[n][k];
        for (int[] flake : flakes) for (int i = 0; i < k; i++) flake[i] = random.nextInt(MAX_VAL + 1);
        return flakes;
    }
}