package leetcode.leetcode4xx.leetcode445;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode ans = null;
        int over = 0;
        while (l1 != null || l2 != null || over != 0) {
            over += (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            ans = new ListNode(over % 10, ans);
            over /= 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return ans;
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
