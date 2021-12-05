package leetcode.leetcode20xx.leetcode2095;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        head = new ListNode(0, head);
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow.next != null) slow.next = slow.next.next;
        return head.next;
    }
}
