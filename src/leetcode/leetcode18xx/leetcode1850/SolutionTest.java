package leetcode.leetcode18xx.leetcode1850;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().getMinSwaps("5489355142", 4));
    }

    @Test
    void test2() {
        assertEquals(4, new Solution().getMinSwaps("11112", 4));
    }

    @Test
    void test3() {
        assertEquals(1, new Solution().getMinSwaps("00123", 1));
    }
}