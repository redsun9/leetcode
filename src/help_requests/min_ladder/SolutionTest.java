package help_requests.min_ladder;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void testRandom() throws InterruptedException {
        int n = 100, maxHeight = 1000;
        assertTrue(StressTester.exactStressTest(
                seed -> generate(n, maxHeight, seed),
                testData -> Solution.minLadder(testData.arr, testData.k),
                testData -> Solution.minLadder(Arrays.stream(testData.arr).boxed().toList(), testData.k),
                1_000_000,
                1,
                100_000
        ));
    }

    private static TestData generate(int n, int maxHeight, long seed) {
        Random random = new Random(seed);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = 1 + random.nextInt(maxHeight);
        return new TestData(arr, random.nextInt(n));
    }

    private record TestData(int[] arr, int k) {
        @Override
        public String toString() {
            return "arr = " + Arrays.toString(arr) + ", k = " + k;
        }
    }
}