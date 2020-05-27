package leetcode.leetcode8xx.leetcode886;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        assertTrue(new Solution().possibleBipartition(4, dislikes));
    }
}