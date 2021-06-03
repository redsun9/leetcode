package leetcode.leetcode18xx.leetcode1805;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(3, new Solution().numDifferentIntegers("a123bc34d8ef34"));
    }

    @Test
    void test2() {
        assertEquals(2, new Solution().numDifferentIntegers("leet1234code234"));
    }

    @Test
    void test3() {
        assertEquals(1, new Solution().numDifferentIntegers("a1b01c001"));
    }

    @Test
    void test4() {
        assertEquals(2, new Solution().numDifferentIntegers("035985750011523523129774573439111590559325a1554234973"));
    }

    @Test
    void test5() {
        assertEquals(1, new Solution().numDifferentIntegers("0i00e"));
    }
}