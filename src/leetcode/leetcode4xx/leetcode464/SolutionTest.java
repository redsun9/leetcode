package leetcode.leetcode4xx.leetcode464;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        assertFalse(new Solution().canIWin(10, 11));
        assertFalse(new Solution2().canIWin(10, 11));
    }

    @Test
    void test2() {
        assertTrue(new Solution().canIWin(10, 0));
        assertTrue(new Solution2().canIWin(10, 0));
    }

    @Test
    void test3() {
        assertTrue(new Solution().canIWin(10, 1));
        assertTrue(new Solution2().canIWin(10, 1));
    }

    @Test
    void test() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        long startTime = System.nanoTime();
        for (int maxChoosableInteger = 1; maxChoosableInteger <= 20; maxChoosableInteger++) {
            for (int desiredTotal = 0; maxChoosableInteger <= 300; maxChoosableInteger++) {
                solution.canIWin(maxChoosableInteger, desiredTotal);
            }
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        for (int maxChoosableInteger = 1; maxChoosableInteger <= 20; maxChoosableInteger++) {
            for (int desiredTotal = 0; maxChoosableInteger <= 300; maxChoosableInteger++) {
                solution2.canIWin(maxChoosableInteger, desiredTotal);
            }
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

    }
}