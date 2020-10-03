package leetcode.leetcode4xx.leetcode470;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {


    /*
        The second solution is ~10% faster
        12638978600
        11260975900
     */
    @Test
    @org.junit.jupiter.api.Disabled
    void perfTest() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000_000; i++) {
            assertTrue(solution.rand10() >= 0);
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000_000; i++) {
            assertTrue(solution2.rand10() >= 0);
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}