package leetcode.leetcode20xx.leetcode2058;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arr = {3, 1};
        ListNode head = LeetcodeUtils.initializeList(arr);
        int[] expected = {-1, -1};
        assertArrayEquals(expected, new Solution().nodesBetweenCriticalPoints(head));
    }

    @Test
    void test2() {
        int[] arr = {5, 3, 1, 2, 5, 1, 2};
        ListNode head = LeetcodeUtils.initializeList(arr);
        int[] expected = {1, 3};
        assertArrayEquals(expected, new Solution().nodesBetweenCriticalPoints(head));
    }

    @Test
    void test3() {
        int[] arr = {1, 3, 2, 2, 3, 2, 2, 2, 7};
        ListNode head = LeetcodeUtils.initializeList(arr);
        int[] expected = {3, 3};
        assertArrayEquals(expected, new Solution().nodesBetweenCriticalPoints(head));
    }

    @Test
    void test4() {
        int[] arr = {2, 3, 3, 2};
        ListNode head = LeetcodeUtils.initializeList(arr);
        int[] expected = {-1, -1};
        assertArrayEquals(expected, new Solution().nodesBetweenCriticalPoints(head));
    }
}