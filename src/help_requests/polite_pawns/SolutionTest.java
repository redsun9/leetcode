package help_requests.polite_pawns;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void test1() {
        int[] arr = {1, 2, 2, 1, 2};
        int[] expected = {1, 2, 2, 2, 1};
        assertArrayEquals(expected, Solution.solveWithExtraMemory(arr));
        assertArrayEquals(expected, Solution.solveInPlace(arr));
    }

    @Test
    void testRandom() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generate(seed, 1, 20),
                Solution::solveWithExtraMemory,
                board -> Solution.solveInPlace(Arrays.copyOf(board, board.length)),
                1_000_000,
                1,
                100_000
        ));
    }

    private static int[] generate(long seed, int minN, int maxN) {
        Random random = new Random(seed);
        int n = minN + random.nextInt(maxN - minN + 1);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = random.nextInt(3);
        return arr;
    }
}