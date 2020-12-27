package leetcode.leetcode16xx.leetcode1680;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(1, new Solution().concatenatedBinary(1));
    }

    @Test
    void test2() {
        assertEquals(27, new Solution().concatenatedBinary(3));
    }

    @Test
    void test3() {
        assertEquals(505379714, new Solution().concatenatedBinary(12));
    }
}