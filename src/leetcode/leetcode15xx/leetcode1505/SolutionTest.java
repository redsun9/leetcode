package leetcode.leetcode15xx.leetcode1505;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("1342", new Solution().minInteger("4321", 4));
    }

    @Test
    void test2() {
        assertEquals("010", new Solution().minInteger("100", 1));
    }

    @Test
    void test3() {
        assertEquals("36789", new Solution().minInteger("36789", 1000));
    }

    @Test
    void test4() {
        assertEquals("22", new Solution().minInteger("22", 4));
    }

    @Test
    void test5() {
        assertEquals("0345989723478563548", new Solution().minInteger("9438957234785635408", 23));
    }
}