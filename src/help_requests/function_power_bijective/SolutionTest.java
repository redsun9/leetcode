package help_requests.function_power_bijective;

import basic.utils.ArrayTools;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static basic.utils.ArrayTools.naturalArray;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {

    @Test
    void testBijectiveWithDummy() throws InterruptedException {
        int minN = 10, maxN = 100, minK = 2, maxK = 1_000;
        assertTrue(StressTester.exactStressTest(
                seed -> generateRandomBijective(minN, maxN, minK, maxK, seed),
                testData -> SolutionBijective.powerBijective(testData.arr, testData.k),
                testData -> SolutionDummy.powerDummy(testData.arr, testData.k),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testLogarithmic() throws InterruptedException {
        int minN = 10, maxN = 100, minK = 2, maxK = 1_000_000_000;
        assertTrue(StressTester.exactStressTest(
                seed -> generateRandomBijective(minN, maxN, minK, maxK, seed),
                testData -> SolutionBijective.powerBijective(testData.arr, testData.k),
                testData -> SolutionLogarithmic.logarithmicPower(testData.arr, testData.k),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testLogarithmicNonBijective() throws InterruptedException {
        int minN = 10, maxN = 100, minK = 2, maxK = 1_000;
        assertTrue(StressTester.exactStressTest(
                seed -> generateRandomNonBijective(minN, maxN, minK, maxK, seed),
                testData -> SolutionDummy.powerDummy(testData.arr, testData.k),
                testData -> SolutionLogarithmic.logarithmicPower(testData.arr, testData.k),
                1_000_000,
                1,
                100_000
        ));
    }

    private static TestData generateRandomBijective(int minN, int maxN, int minK, int maxK, long seed) {
        Random random = new Random(seed);
        int n = minN + random.nextInt(maxN - minN + 1);
        int k = minK + random.nextInt(maxK - minK + 1);
        int[] ans = naturalArray(n);
        ArrayTools.shuffle(ans, random);
        return new TestData(ans, k);
    }

    private static TestData generateRandomNonBijective(int minN, int maxN, int minK, int maxK, long seed) {
        Random random = new Random(seed);
        int n = minN + random.nextInt(maxN - minN + 1);
        int k = minK + random.nextInt(maxK - minK + 1);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = random.nextInt(n);
        return new TestData(ans, k);
    }

    private record TestData(int[] arr, int k) {
    }
}