package leetcode.leetcode24xx.leetcode2478;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "23542185131";
        int k = 3, minLength = 2, expected = 3;
        assertEquals(expected, new Solution().beautifulPartitions(s, k, minLength));
    }

    @Test
    void test2() {
        String s = "23542185131";
        int k = 3, minLength = 3, expected = 1;
        assertEquals(expected, new Solution().beautifulPartitions(s, k, minLength));
    }

    @Test
    void test3() {
        String s = "3312958";
        int k = 3, minLength = 1, expected = 1;
        assertEquals(expected, new Solution().beautifulPartitions(s, k, minLength));
    }

    @Test
    void test4() {
        String s = "22";
        int k = 1, minLength = 1, expected = 0;
        assertEquals(expected, new Solution().beautifulPartitions(s, k, minLength));
    }
}