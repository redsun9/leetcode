package leetcode.leetcode1xx.leetcode147;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode ans = new ListNode();
        while (head != null) {
            int val = head.val;
            ListNode next = head.next;
            ListNode tmp = ans;
            while (tmp.next != null && tmp.next.val < val) tmp = tmp.next;
            head.next = tmp.next;
            tmp.next = head;
            head = next;
        }
        return ans.next;
    }
}
