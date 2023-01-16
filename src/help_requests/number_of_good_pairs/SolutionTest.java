package help_requests.number_of_good_pairs;

import basic.utils.ArrayTools;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private static final int minN = 2, maxN = 1000;

    @Test
    void test1() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                SolutionTest::generateTestData,
                testData -> DummySolution.numberOfGoodPairs(testData[0], testData[1]),
                testData -> Solution.numberOfGoodPairs(testData[0], testData[1]),
                100_000,
                1,
                10_000
        ));

    }

    private static int[][] generateTestData(long seed) {
        Random random = new Random(seed);
        int n = minN + random.nextInt(maxN - minN + 1);
        return new int[][]{generatePermutation(n, random), generatePermutation(n, random)};
    }

    private static int[] generatePermutation(int n, Random random) {
        int[] arr = ArrayTools.naturalArray(n);
        ArrayTools.shuffle(arr, random);
        return arr;
    }
}