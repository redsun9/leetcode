package leetcode.leetcode1xx.leetcode148;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sortList() {
        int[] nums = {4, 2, 1, 3};
        ListNode node = LeetcodeUtils.initializeList(nums);
        int[] expected = {1, 2, 3, 4};
        ListNode actual = new Solution().sortList(node);
        for (int expectedVal : expected) {
            assertNotNull(actual);
            assertEquals(expectedVal, actual.val);
            actual = actual.next;
        }
        assertNull(actual);
    }
}