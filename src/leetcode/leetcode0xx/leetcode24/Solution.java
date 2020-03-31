package leetcode.leetcode0xx.leetcode24;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = new ListNode(0);
        result.next = head;

        ListNode p = result;
        ListNode q = p.next;
        ListNode r = q.next;
        ListNode t = r.next;

        while (true) {
            p.next = r;
            q.next = t;
            r.next = q;
            if (t == null) break;
            p = q;
            q = t;
            r = q.next;
            if (r == null) break;
            t = r.next;
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
