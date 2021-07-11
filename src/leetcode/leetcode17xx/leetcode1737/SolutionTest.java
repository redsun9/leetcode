package leetcode.leetcode17xx.leetcode1737;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(1, new Solution().minCharacters("cc", "abca"));
    }

    @Test
    void test2() {
        assertEquals(2, new Solution().minCharacters("qxbzazzh", "x"));
    }
}