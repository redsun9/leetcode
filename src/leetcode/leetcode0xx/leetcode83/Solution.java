package leetcode.leetcode0xx.leetcode83;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.val == tmp.next.val) tmp.next = tmp.next.next;
            else tmp = tmp.next;
        }
        return head;
    }
}
