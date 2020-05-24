package leetcode.leetcode2xx.leetcode203;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(0, head);
        ListNode tmp = ans;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else tmp = tmp.next;
        }
        return ans.next;
    }
}
