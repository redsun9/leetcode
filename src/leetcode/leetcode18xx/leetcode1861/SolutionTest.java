package leetcode.leetcode18xx.leetcode1861;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        char[][] box = {
                {'#', '.', '#'}
        };
        char[][] expected = {
                {'.'},
                {'#'},
                {'#'}
        };
        assertArrayEquals(expected, new Solution().rotateTheBox(box));
    }

    @Test
    void test2() {
        char[][] box = {
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        };
        char[][] expected = {
                {'#', '.'},
                {'#', '#'},
                {'*', '*'},
                {'.', '.'}
        };
        assertArrayEquals(expected, new Solution().rotateTheBox(box));
    }

    @Test
    void test3() {
        char[][] box = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };
        char[][] expected = {
                {'.', '#', '#'},
                {'.', '#', '#'},
                {'#', '#', '*'},
                {'#', '*', '.'},
                {'#', '.', '*'},
                {'#', '.', '.'}
        };
        assertArrayEquals(expected, new Solution().rotateTheBox(box));
    }
}