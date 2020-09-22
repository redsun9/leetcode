package leetcode.leetcode8xx.leetcode864;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] grid = {"@.a.#", "###.#", "b.A.B"};
        assertEquals(8, new Solution().shortestPathAllKeys(grid));
    }

    @Test
    void test2() {
        String[] grid = {"@..aA", "..B#.", "....b"};
        assertEquals(6, new Solution().shortestPathAllKeys(grid));
    }
}