package leetcode.leetcode0xx.leetcode97;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        assertTrue(new Solution().isInterleave(s1, s2, s3));
    }

    @Test
    void test2() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        assertTrue(new Solution().isInterleave(s1, s2, s3));
    }
}
