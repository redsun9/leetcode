package leetcode.leetcode1xx.leetcode148;

import leetcode.tools.ListNode;

//quick sort
public class Solution {
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

        ListNode leftPart = null;
        ListNode rightPart = null;

        int val = head.val;
        ListNode midStart = head, midEnd = midStart;
        head = head.next;
        midStart.next = null;

        while (head != null) {
            ListNode next = head.next;
            if (head.val < val) {
                head.next = leftPart;
                leftPart = head;
            } else if (head.val > val) {
                head.next = rightPart;
                rightPart = head;
            } else {
                head.next = midStart;
                midStart = head;
            }
            head = next;
        }
        ListNode left = sortList(leftPart);
        ListNode right = sortList(rightPart);

        ListNode ans = midStart;
        if (left != null) {
            ans = left;
            while (left.next != null) left = left.next;
            left.next = midStart;
        }
        midEnd.next = right;
        return ans;
    }
}
