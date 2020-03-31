package leetcode.leetcode581;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertEquals(5, solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        assertEquals(3, solution.findUnsortedSubarray(new int[]{1, 4, 3, 2, 5}));
    }

}