package leetcode.leetcode17xx.leetcode1721;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node1 = head;
        while (--k > 0) node1 = node1.next;
        ListNode node2 = head, tmp = node1.next;
        while (tmp != null) {
            node2 = node2.next;
            tmp = tmp.next;
        }
        int t = node1.val;
        node1.val = node2.val;
        node2.val = t;
        return head;
    }
}
