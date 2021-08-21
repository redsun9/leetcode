package leetcode.leetcode19xx.leetcode1977;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution2().numberOfCombinations("327"));
    }

    @Test
    void test2() {
        assertEquals(0, new Solution2().numberOfCombinations("094"));
    }

    @Test
    void test3() {
        assertEquals(0, new Solution2().numberOfCombinations("0"));
    }

    @Test
    void test4() {
        assertEquals(101, new Solution2().numberOfCombinations("9999999999999"));
    }

    @Test
    void test5() {
        assertEquals(3, new Solution2().numberOfCombinations("2423"));
    }
}