package leetcode.leetcode2xx.leetcode277;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    @Disabled
    void testRandom() throws InterruptedException {
        int n = 10;
        assertTrue(StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    int ans = random.nextInt(n);
                    return new Solution(ans, n, seed);
                },
                x -> x.ans,
                x -> x.findCelebrity(x.n)
        ));
    }
}