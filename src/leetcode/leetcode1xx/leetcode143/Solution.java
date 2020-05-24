package leetcode.leetcode1xx.leetcode143;

import leetcode.tools.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p1.next = reverseList(p1.next);
        ListNode mid = p1.next;
        p1.next = null;
        p1 = mid;
        //1->2->3->5->4
        while (head != null) {
            ListNode next = head.next;
            head.next = p1;
            if (p1 != null) {
                ListNode next2 = p1.next;
                p1.next = next;
                p1 = next2;
            }
            head = next;
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
