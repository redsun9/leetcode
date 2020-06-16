package leetcode.leetcode0xx.leetcode92;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode leftStart = new ListNode(0, head);
        ListNode leftEnd = leftStart;
        while (m != 1) {
            leftEnd = leftEnd.next;
            m--;
            n--;
        }
        ListNode midEnd = leftEnd.next;
        ListNode midStart = midEnd;
        ListNode rightStart = midStart.next;
        while (n != 1) {
            ListNode tmp = rightStart.next;
            rightStart.next = midStart;
            midStart = rightStart;
            rightStart = tmp;
            n--;
        }

        leftEnd.next = midStart;
        midEnd.next = rightStart;
        return leftStart.next;
    }
}
