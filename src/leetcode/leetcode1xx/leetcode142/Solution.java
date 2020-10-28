package leetcode.leetcode1xx.leetcode142;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (true) {
            if (first == null || first.next == null) return null;
            first = first.next.next;
            second = second.next;
            if (first == second) break;
        }
        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
