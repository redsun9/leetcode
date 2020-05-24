package leetcode.leetcode1xx.leetcode148;

import leetcode.tools.ListNode;

//merge sort
public class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) {
            if (head.val > head.next.val) {
                head.next.next = head;
                head = head.next;
                head.next.next = null;
            }
            return head;
        }
        ListNode[] parts = {null, null};
        int counter = 0;
        while (head != null) {
            ListNode next = head.next;
            head.next = parts[counter & 1];
            parts[counter & 1] = head;
            head = next;
            counter++;
        }
        parts[0] = sortList(parts[0]);
        parts[1] = sortList(parts[1]);


        ListNode ans = new ListNode();
        ListNode tmp = ans;
        ListNode l1 = parts[0], l2 = parts[1];
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                tmp = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                tmp = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) tmp.next = l1;
        if (l2 != null) tmp.next = l2;
        return ans.next;
    }
}
