package leetcode.leetcode3xx.leetcode328;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode evenStart = head.next;
        ListNode even = evenStart;
        boolean isOdd = true;
        ListNode tmp = head.next.next;
        while (tmp != null) {
            if (isOdd) {
                odd.next = tmp;
                odd = tmp;
            } else {
                even.next = tmp;
                even = tmp;
            }
            isOdd = !isOdd;
            tmp = tmp.next;
        }
        odd.next = evenStart;
        even.next = null;
        return head;
    }
}
