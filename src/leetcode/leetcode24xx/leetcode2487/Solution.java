package leetcode.leetcode24xx.leetcode2487;

import leetcode.tools.ListNode;

@SuppressWarnings("DuplicatedCode")
public class Solution {

    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);
        ListNode ans = new ListNode(Integer.MIN_VALUE, null);
        ListNode l1 = head, l2 = ans;
        while (l1 != null) {
            if (l1.val >= l2.val) {
                l2.next = l1;
                l2 = l2.next;
            }
            l1 = l1.next;
        }
        l2.next = null;
        return reverseList(ans.next);
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
