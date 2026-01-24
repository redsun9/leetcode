package leetcode.leetcode37xx.leetcode3791;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(9, new Solution().countBalanced(1, 100));
    }

    @Test
    void test2() {
        assertEquals(7346326826082979L, new Solution().countBalanced(213121, 230188428234223434L));
    }
}