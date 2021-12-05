package leetcode.leetcode20xx.leetcode2095;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arrInitial = {};
        int[] arrExpected = {};
        ListNode head = LeetcodeUtils.initializeList(arrInitial);
        ListNode actual = new Solution().deleteMiddle(head);
        ListNode expected = LeetcodeUtils.initializeList(arrExpected);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] arrInitial = {1};
        int[] arrExpected = {};
        ListNode head = LeetcodeUtils.initializeList(arrInitial);
        ListNode actual = new Solution().deleteMiddle(head);
        ListNode expected = LeetcodeUtils.initializeList(arrExpected);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[] arrInitial = {1, 2};
        int[] arrExpected = {1};
        ListNode head = LeetcodeUtils.initializeList(arrInitial);
        ListNode actual = new Solution().deleteMiddle(head);
        ListNode expected = LeetcodeUtils.initializeList(arrExpected);
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int[] arrInitial = {1, 2, 3};
        int[] arrExpected = {1, 3};
        ListNode head = LeetcodeUtils.initializeList(arrInitial);
        ListNode actual = new Solution().deleteMiddle(head);
        ListNode expected = LeetcodeUtils.initializeList(arrExpected);
        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        int[] arrInitial = {1, 2, 3, 4};
        int[] arrExpected = {1, 2, 4};
        ListNode head = LeetcodeUtils.initializeList(arrInitial);
        ListNode actual = new Solution().deleteMiddle(head);
        ListNode expected = LeetcodeUtils.initializeList(arrExpected);
        assertEquals(expected, actual);
    }

    @Test
    void test6() {
        int[] arrInitial = {1, 2, 3, 4, 5};
        int[] arrExpected = {1, 2, 4, 5};
        ListNode head = LeetcodeUtils.initializeList(arrInitial);
        ListNode actual = new Solution().deleteMiddle(head);
        ListNode expected = LeetcodeUtils.initializeList(arrExpected);
        assertEquals(expected, actual);
    }
}