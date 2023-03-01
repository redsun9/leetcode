package help_requests.necklace_cut;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import static help_requests.necklace_cut.NeckLaceTools.check;
import static help_requests.necklace_cut.NeckLaceTools.generate;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("DataFlowIssue")
class Solution3Test {

    @Test
    void test1() {
        int[] necklace = {1, 2, 1, 2, 1, 2, 1, 2, 3, 3};
        int[] expected = {4, 9};
        int[] actual1 = Solution3.getMinimumCuts(necklace);
        assertArrayEquals(expected, actual1);
        int[] actual2 = Solution32.getMinimumCuts(necklace);
        assertArrayEquals(expected, actual2);
    }

    @Test
    void testRandomSeparatable() throws InterruptedException {
        int n = 100;
        assertTrue(StressTester.constructionStressTest(
                seed -> generate(n, seed, 3, true),
                Solution3::getMinimumCuts,
                (necklace, actual) -> NeckLaceTools.check(necklace, actual, 3),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testCorrectness() throws InterruptedException {
        int n = 10;
        assertTrue(StressTester.constructionStressTest(
                seed -> generate(n, seed, 3, true),
                Solution3::getMinimumCuts,
                (arr, actual) -> Solution32.getMinimumCuts(arr).length == actual.length && check(arr, actual, 3),
                1_000_000,
                1,
                100_000
        ));
    }
}