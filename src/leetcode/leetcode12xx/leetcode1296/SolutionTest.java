package leetcode.leetcode12xx.leetcode1296;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] a = {1, 2, 3, 3, 4, 4, 5, 6};
        assertTrue(new Solution().isPossibleDivide(a, 4));
    }
}