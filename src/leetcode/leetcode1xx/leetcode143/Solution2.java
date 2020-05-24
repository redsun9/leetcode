package leetcode.leetcode1xx.leetcode143;

import leetcode.tools.ListNode;

public class Solution2 {
    public void reorderList(ListNode head) {
        while (head != null) {
            head.next = reverseList(head.next);
            head = head.next;
        }
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = null;
        ListNode q = head;

        while (q != null) {
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
}
