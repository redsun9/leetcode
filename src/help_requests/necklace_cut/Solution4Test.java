package help_requests.necklace_cut;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import static help_requests.necklace_cut.NeckLaceTools.check;
import static help_requests.necklace_cut.NeckLaceTools.generate;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("DataFlowIssue")
class Solution4Test {

    @Test
    void testRandom() throws InterruptedException {
        int n = 100;
        assertTrue(StressTester.constructionStressTest(
                seed -> generate(n, seed, 4, true),
                Solution4::getMinimumCuts,
                (necklace, actual) -> check(necklace, actual, 4),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testCorrectness() throws InterruptedException {
        int n = 100;
        assertTrue(StressTester.constructionStressTest(
                seed -> generate(n, seed, 4, true),
                Solution42::getMinimumCuts,
                (arr, actual) -> Solution4.getMinimumCuts(arr).length == actual.length && check(arr, actual, 4),
                1_000_000,
                1,
                100_000
        ));
    }
}