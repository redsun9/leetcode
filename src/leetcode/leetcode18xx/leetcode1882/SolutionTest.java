package leetcode.leetcode18xx.leetcode1882;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] servers = {3, 3, 2}, tasks = {1, 2, 3, 2, 1, 2};
        int[] expected = {2, 2, 0, 2, 1, 2};
        assertArrayEquals(expected, new Solution().assignTasks(servers, tasks));
    }

    @Test
    void test2() {
        int[] servers = {5, 1, 4, 3, 2}, tasks = {2, 1, 2, 4, 5, 2, 1};
        int[] expected = {1, 4, 1, 4, 1, 3, 2};
        assertArrayEquals(expected, new Solution().assignTasks(servers, tasks));
    }

    @Test
    void test3() {
        int[] servers = {74, 57, 61, 82, 67, 97, 67, 21, 61, 79, 21, 50, 14, 88, 48, 52, 76, 64},
                tasks = {21, 100, 48, 64, 20, 8, 28, 10, 3, 63, 7};
        int[] expected = {12, 7, 10, 14, 11, 15, 1, 2, 8, 17, 4};
        assertArrayEquals(expected, new Solution().assignTasks(servers, tasks));
    }
}
