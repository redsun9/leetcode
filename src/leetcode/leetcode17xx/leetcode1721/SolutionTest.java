package leetcode.leetcode17xx.leetcode1721;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head = LeetcodeUtils.initializeList(arr1);
        int[] arr2 = {1, 4, 3, 2, 5};
        ListNode expected = LeetcodeUtils.initializeList(arr2);
        assertEquals(expected, new Solution().swapNodes(head, 2));
    }

    @Test
    void test2() {
        int[] arr1 = {7, 9, 6, 6, 7, 8, 3, 0, 9, 5};
        ListNode head = LeetcodeUtils.initializeList(arr1);
        int[] arr2 = {7, 9, 6, 6, 8, 7, 3, 0, 9, 5};
        ListNode expected = LeetcodeUtils.initializeList(arr2);
        assertEquals(expected, new Solution().swapNodes(head, 5));
    }

    @Test
    void test3() {
        int[] arr1 = {1};
        ListNode head = LeetcodeUtils.initializeList(arr1);
        int[] arr2 = {1};
        ListNode expected = LeetcodeUtils.initializeList(arr2);
        assertEquals(expected, new Solution().swapNodes(head, 1));
    }

    @Test
    void test4() {
        int[] arr1 = {1, 2};
        ListNode head = LeetcodeUtils.initializeList(arr1);
        int[] arr2 = {2, 1};
        ListNode expected = LeetcodeUtils.initializeList(arr2);
        assertEquals(expected, new Solution().swapNodes(head, 1));
    }

    @Test
    void test5() {
        int[] arr1 = {1, 2, 3};
        ListNode head = LeetcodeUtils.initializeList(arr1);
        int[] arr2 = {1, 2, 3};
        ListNode expected = LeetcodeUtils.initializeList(arr2);
        assertEquals(expected, new Solution().swapNodes(head, 2));
    }
}