package leetcode.leetcode18xx.leetcode1884;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test() {
        assertEquals(2, new Solution().twoEggDrop(2));
        assertEquals(14, new Solution().twoEggDrop(100));
    }
}