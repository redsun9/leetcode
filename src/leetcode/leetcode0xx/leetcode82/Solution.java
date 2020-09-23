package leetcode.leetcode0xx.leetcode82;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode ans = new ListNode(head.val - 1, head);
        ListNode tmp = ans;
        int toDelete = ans.val;
        while (tmp.next != null) {
            if (tmp.next.val == toDelete) tmp.next = tmp.next.next;
            else if (tmp.next.next != null && tmp.next.next.val == tmp.next.val) toDelete = tmp.next.val;
            else tmp = tmp.next;
        }
        return ans.next;
    }
}
