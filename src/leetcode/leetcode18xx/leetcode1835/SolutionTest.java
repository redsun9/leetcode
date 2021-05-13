package leetcode.leetcode18xx.leetcode1835;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arr1 = {1, 2, 3}, arr2 = {6, 5};
        assertEquals(0, new Solution().getXORSum(arr1, arr2));
    }

    @Test
    void test2() {
        int[] arr1 = {12}, arr2 = {4};
        assertEquals(4, new Solution().getXORSum(arr1, arr2));
    }
}