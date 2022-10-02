package leetcode.leetcode24xx.leetcode2429;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(3, new Solution().minimizeXor(3, 5));
    }

    @Test
    void test2() {
        assertEquals(3, new Solution().minimizeXor(1, 12));
    }
}