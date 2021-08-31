package leetcode.leetcode8xx.leetcode854;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(1, new Solution().kSimilarity("ab", "ba"));
    }

    @Test
    void test2() {
        assertEquals(2, new Solution().kSimilarity("abc", "bca"));
    }

    @Test
    void test3() {
        assertEquals(2, new Solution().kSimilarity("abac", "baca"));
    }

    @Test
    void test4() {
        assertEquals(2, new Solution().kSimilarity("aabc", "abca"));
    }
}