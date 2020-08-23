package leetcode.leetcode15xx.leetcode1559;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        char[][] grid = {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
        assertTrue(new Solution().containsCycle(grid));
    }

    @Test
    void test2() {
        char[][] grid = {{'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}};
        assertTrue(new Solution().containsCycle(grid));
    }

    @Test
    void test3() {
        char[][] grid = {{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}};
        assertFalse(new Solution().containsCycle(grid));
    }


}