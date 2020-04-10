package leetcode.leetcode0xx.leetcode61;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        if (k % length == 0) return head;
        k = length - k % length;
        tail.next = head;
        for (int i = 1; i < k; i++) {
            head = head.next;
        }
        ListNode ans = head.next;
        head.next = null;
        return ans;
    }
}
