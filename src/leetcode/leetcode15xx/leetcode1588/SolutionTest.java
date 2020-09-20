package leetcode.leetcode15xx.leetcode1588;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arr = {1, 4, 2, 5, 3};
        assertEquals(58, new Solution().sumOddLengthSubarrays(arr));
    }

    @Test
    void test2() {
        int[] arr = {1, 2};
        assertEquals(3, new Solution().sumOddLengthSubarrays(arr));
    }

    @Test
    void test3() {
        int[] arr = {10, 11, 12};
        assertEquals(66, new Solution().sumOddLengthSubarrays(arr));
    }
}
