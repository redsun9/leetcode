package leetcode.leetcode21xx.leetcode2181;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode tmp = ans;
        while (head.next != null) {
            tmp.next = new ListNode(0);
            tmp = tmp.next;
            head = head.next;
            while (head.val != 0) {
                tmp.val += head.val;
                head = head.next;
            }
        }
        return ans.next;
    }
}
