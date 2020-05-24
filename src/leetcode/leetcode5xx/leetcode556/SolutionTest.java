package leetcode.leetcode5xx.leetcode556;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(21, new Solution().nextGreaterElement(12));
    }

    @Test
    void test2() {
        assertEquals(-1, new Solution().nextGreaterElement(21));
    }

}