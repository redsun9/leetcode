package leetcode.leetcode19xx.leetcode1931;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test3() {
        assertEquals(580986, new Solution().colorTheGrid(5, 5));
    }

    @Test
    void test4() {
        assertEquals(106494, new Solution().colorTheGrid(3, 7));
    }
}