package leetcode.leetcode12xx.leetcode1278;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "abc";
        int k = 2;
        assertEquals(1, new Solution().palindromePartition(s, k));
    }

    @Test
    void test2() {
        String s = "aabbc";
        int k = 3;
        assertEquals(0, new Solution().palindromePartition(s, k));
    }
}