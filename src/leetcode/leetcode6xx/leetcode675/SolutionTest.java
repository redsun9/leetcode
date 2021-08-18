package leetcode.leetcode6xx.leetcode675;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        List<List<Integer>> forest = List.of(List.of(1, 2, 3), List.of(0, 0, 4), List.of(7, 6, 5));
        assertEquals(6, new Solution().cutOffTree(forest));
    }

    @Test
    void test2() {
        List<List<Integer>> forest = List.of(List.of(1, 2, 3), List.of(0, 0, 0), List.of(7, 6, 5));
        assertEquals(-1, new Solution().cutOffTree(forest));
    }

    @Test
    void test3() {
        List<List<Integer>> forest = List.of(List.of(2, 3, 4), List.of(0, 0, 5), List.of(8, 7, 6));
        assertEquals(6, new Solution().cutOffTree(forest));
    }
}