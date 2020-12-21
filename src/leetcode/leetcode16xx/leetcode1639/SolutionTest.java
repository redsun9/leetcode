package leetcode.leetcode16xx.leetcode1639;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] words = {"acca", "bbbb", "caca"};
        String target = "aba";
        assertEquals(6, new Solution().numWays(words, target));
    }

    @Test
    void test2() {
        String[] words = {"abba", "baab"};
        String target = "bab";
        assertEquals(4, new Solution().numWays(words, target));
    }

    @Test
    void test3() {
        String[] words = {"abcd"};
        String target = "abcd";
        assertEquals(1, new Solution().numWays(words, target));
    }

    @Test
    void test4() {
        String[] words = {"abab", "baba", "abba", "baab"};
        String target = "abba";
        assertEquals(16, new Solution().numWays(words, target));
    }
}