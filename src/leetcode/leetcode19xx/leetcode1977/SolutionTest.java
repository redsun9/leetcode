package leetcode.leetcode19xx.leetcode1977;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().numberOfCombinations("327"));
        assertEquals(2, new Solution2().numberOfCombinations("327"));
        assertEquals(2, new Solution3().numberOfCombinations("327"));
        assertEquals(2, new Solution4().numberOfCombinations("327"));
    }

    @Test
    void test2() {
        assertEquals(0, new Solution().numberOfCombinations("094"));
        assertEquals(0, new Solution2().numberOfCombinations("094"));
        assertEquals(0, new Solution3().numberOfCombinations("094"));
        assertEquals(0, new Solution4().numberOfCombinations("094"));
    }

    @Test
    void test3() {
        assertEquals(0, new Solution().numberOfCombinations("0"));
        assertEquals(0, new Solution2().numberOfCombinations("0"));
        assertEquals(0, new Solution3().numberOfCombinations("0"));
        assertEquals(0, new Solution4().numberOfCombinations("0"));
    }

    @Test
    void test4() {
        assertEquals(101, new Solution().numberOfCombinations("9999999999999"));
        assertEquals(101, new Solution2().numberOfCombinations("9999999999999"));
        assertEquals(101, new Solution3().numberOfCombinations("9999999999999"));
        assertEquals(101, new Solution4().numberOfCombinations("9999999999999"));
    }

    @Test
    void test5() {
        assertEquals(3, new Solution().numberOfCombinations("2423"));
        assertEquals(3, new Solution2().numberOfCombinations("2423"));
        assertEquals(3, new Solution3().numberOfCombinations("2423"));
        assertEquals(3, new Solution4().numberOfCombinations("2423"));
    }

    @Test
    void test6() {
        assertEquals(2, new Solution().numberOfCombinations("1203"));
        assertEquals(2, new Solution2().numberOfCombinations("1203"));
        assertEquals(2, new Solution3().numberOfCombinations("1203"));
        assertEquals(2, new Solution4().numberOfCombinations("1203"));
    }
}