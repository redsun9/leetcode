package leetcode.leetcode16xx.leetcode1668;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().maxRepeating("ababc", "ab"));
    }

    @Test
    void test2() {
        assertEquals(1, new Solution().maxRepeating("ababc", "ba"));
    }

    @Test
    void test3() {
        assertEquals(0, new Solution().maxRepeating("ababc", "ac"));
    }

    @Test
    void test4() {
        assertEquals(2, new Solution().maxRepeating("ababaaba", "aba"));
    }

    @Test
    void test5() {
        assertEquals(27, new Solution().maxRepeating("aaaaaaaaaaaaaaaaaaaaaaaaaaa", "a"));
    }
}