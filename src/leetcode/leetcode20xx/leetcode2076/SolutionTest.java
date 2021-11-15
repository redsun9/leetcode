package leetcode.leetcode20xx.leetcode2076;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int n = 3;
        int[][] restrictions = {{0, 1}}, requests = {{0, 2}, {2, 1}};
        boolean[] expected = {true, false};
        assertArrayEquals(expected, new Solution().friendRequests(n, restrictions, requests));
    }

    @Test
    void test2() {
        int n = 3;
        int[][] restrictions = {{0, 1}}, requests = {{1, 2}, {0, 2}};
        boolean[] expected = {true, false};
        assertArrayEquals(expected, new Solution().friendRequests(n, restrictions, requests));
    }

    @Test
    void test3() {
        int n = 5;
        int[][] restrictions = {{0, 1}, {1, 2}, {2, 3}}, requests = {{0, 4}, {1, 2}, {3, 1}, {3, 4}};
        boolean[] expected = {true, false, true, false};
        assertArrayEquals(expected, new Solution().friendRequests(n, restrictions, requests));
    }
}