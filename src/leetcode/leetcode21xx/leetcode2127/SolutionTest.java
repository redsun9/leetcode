package leetcode.leetcode21xx.leetcode2127;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] favorite = {2, 2, 1, 2};
        assertEquals(3, new Solution().maximumInvitations(favorite));
    }

    @Test
    void test2() {
        int[] favorite = {1, 2, 0};
        assertEquals(3, new Solution().maximumInvitations(favorite));
    }

    @Test
    void test3() {
        int[] favorite = {3, 0, 1, 4, 1};
        assertEquals(4, new Solution().maximumInvitations(favorite));
    }

    @Test
    void test4() {
        int[] favorite = {1, 0, 0, 2, 1, 4, 7, 8, 9, 6, 7, 10, 8};
        assertEquals(6, new Solution().maximumInvitations(favorite));
    }

    @Test
    void test5() {
        int[] favorite = {1, 2, 3, 4, 5, 6, 3, 8, 9, 10, 11, 8};
        assertEquals(4, new Solution().maximumInvitations(favorite));
    }
}