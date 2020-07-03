package leetcode.leetcode9xx.leetcode957;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] cells = {1, 0, 0, 1, 0, 0, 1, 0};
        int[] expected = {0, 0, 1, 1, 1, 1, 1, 0};
        assertArrayEquals(expected, new Solution().prisonAfterNDays(cells, 1000000000));
    }

    @Test
    void test2() {
        for (int i = 0; i < 1 << (Solution.length - 2); i++) {
            assertEquals(i, Solution.encode(Solution.decode(i)));
        }
    }
}