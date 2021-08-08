package leetcode.leetcode9xx.leetcode991;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().brokenCalc(2, 3));
    }

    @Test
    void test2() {
        assertEquals(2, new Solution().brokenCalc(5, 8));
    }

    @Test
    void test3() {
        assertEquals(3, new Solution().brokenCalc(3, 10));
    }

    @Test
    void test4() {
        assertEquals(1023, new Solution().brokenCalc(1024, 1));
    }
}