package leetcode.leetcode18xx.leetcode1808;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(6, new Solution().maxNiceDivisors(5));
    }

    @Test
    void test2() {
        assertEquals(18, new Solution().maxNiceDivisors(8));
    }

    @Test
    void test3() {
        assertEquals(2, new Solution().maxNiceDivisors(2));
    }

    @Test
    void test4() {
        assertEquals(1, new Solution().maxNiceDivisors(1));
    }

    @Test
    void test5() {
        assertEquals(3, new Solution().maxNiceDivisors(3));
    }

    @Test
    void test6() {
        assertEquals(351761402, new Solution().maxNiceDivisors(98));
    }
}