package leetcode.leetcode3xx.leetcode322;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameParameterValue")
class SolutionTest {

    @Test
    void testRandom2() throws InterruptedException {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        assertTrue(StressTester.exactStressTest(
                seed -> TestData.generate(seed, 2, 20, 100, 1000),
                data -> solution.coinChange(data.coins(), data.amount()),
                data -> solution2.coinChange(data.coins(), data.amount()),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testRandom3() throws InterruptedException {
        Solution solution = new Solution();
        Solution3 solution3 = new Solution3();

        assertTrue(StressTester.exactStressTest(
                seed -> TestData.generate(seed, 2, 20, 100, 1000),
                data -> solution.coinChange(data.coins(), data.amount()),
                data -> solution3.coinChange(data.coins(), data.amount()),
                1_000_000,
                1,
                100_000
        ));
    }

    @Test
    void testRandom4() throws InterruptedException {
        Solution solution = new Solution();
        Solution4 solution4 = new Solution4();

        assertTrue(StressTester.exactStressTest(
                seed -> TestData.generate(seed, 2, 20, 100, 1000),
                data -> solution.coinChange(data.coins(), data.amount()),
                data -> solution4.coinChange(data.coins(), data.amount()),
                1_000_000,
                1,
                100_000
        ));
    }
}