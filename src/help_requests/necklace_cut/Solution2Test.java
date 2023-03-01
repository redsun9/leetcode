package help_requests.necklace_cut;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static help_requests.necklace_cut.NeckLaceTools.generate;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameParameterValue")
class Solution2Test {

    @Test
    void testRandomSeparatable() throws InterruptedException {
        int n = 1000;
        assertTrue(StressTester.constructionStressTest(
                seed -> generate(n, seed, 2, true),
                Solution2::getMinimumCuts,
                (necklace, actual) -> NeckLaceTools.check(necklace, actual, 2),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testRandomOdd() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> generateOdd(1, 101, seed),
                Solution2::getMinimumCuts,
                testData -> null,
                1_000,
                1,
                0
        ));
    }

    @Test
    void testRandomNonSeparatable() throws InterruptedException {
        int n = 1000;
        assertTrue(StressTester.exactStressTest(
                seed -> generate(n, seed, 2, false),
                Solution2::getMinimumCuts,
                testData -> null,
                1_000,
                1,
                0
        ));
    }

    private static int[] generateOdd(int minN, int maxN, long seed) {
        Random random = new Random(seed);
        int n = minN + 2 * random.nextInt((maxN - minN) / 2 + 1);
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) arr[i] = 1 + random.nextInt(2);
        return arr;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int[] arr = generate(10, i, 2, true);
            int[] cuts = Solution2.getMinimumCuts(arr);
            System.out.println("minCuts(" + Arrays.toString(arr) + ") => " + Arrays.toString(cuts));
        }
    }
}