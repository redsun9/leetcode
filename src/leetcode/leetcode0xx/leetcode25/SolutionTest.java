package leetcode.leetcode0xx.leetcode25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void reverseKGroup() {
        Solution solution = new Solution();
        ListNode head = new ListNode(0);
        for (int n = 20; n <= 1000; n++) {
            for (int k = 1; k <= 10; k++) {
                ListNode tmp = head;
                for (int j = 1; j < n; j++) {
                    tmp.next = new ListNode(j);
                    tmp = tmp.next;
                }
                ListNode result = solution.reverseKGroup(head, k);
                for (int g = 0; g < n / k; g++) {
                    for (int h = 0; h < k; h++) {
                        assertEquals((g + 1) * k - 1 - h, result.val);
                        result = result.next;
                    }
                }
                for (int h = n / k * k; h < n; h++) {
                    assertEquals(h, result.val);
                    result = result.next;
                }
            }
        }
    }
}