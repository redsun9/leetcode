package leetcode.leetcode22xx.leetcode2213;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "babacc", queryCharacters = "bcb";
        int[] queryIndices = {1, 3, 3}, expected = {3, 3, 4};
        assertArrayEquals(expected, new Solution().longestRepeating(s, queryCharacters, queryIndices));
    }

    @Test
    void test2() {
        String s = "abyzz", queryCharacters = "aa";
        int[] queryIndices = {2, 1}, expected = {2, 3};
        assertArrayEquals(expected, new Solution().longestRepeating(s, queryCharacters, queryIndices));
    }
}