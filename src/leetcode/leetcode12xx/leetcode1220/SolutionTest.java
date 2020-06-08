package leetcode.leetcode12xx.leetcode1220;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test() {
        assertEquals(5, new Solution().countVowelPermutation(1));
        assertEquals(10, new Solution().countVowelPermutation(2));
        assertEquals(68, new Solution().countVowelPermutation(5));

    }
}