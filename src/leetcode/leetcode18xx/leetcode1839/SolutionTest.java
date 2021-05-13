package leetcode.leetcode18xx.leetcode1839;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(13, new Solution().longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }

    @Test
    void test2() {
        assertEquals(5, new Solution().longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
    }

    @Test
    void test3() {
        assertEquals(0, new Solution().longestBeautifulSubstring("a"));
    }
}