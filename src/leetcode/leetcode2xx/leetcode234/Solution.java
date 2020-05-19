package leetcode.leetcode2xx.leetcode234;

import leetcode.tools.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int n = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            n++;
        }
        ListNode startOfSecond = head;
        int lengthToCheck = n / 2;
        for (int i = 0, end = n - lengthToCheck; i < end; i++) {
            startOfSecond = startOfSecond.next;
        }
        //reverse first half

        ListNode p = null;
        ListNode q = head;
        ListNode r = head.next;
        for (int i = 0; i < lengthToCheck; i++) {
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        // p - начаало
        while (p != null) {
            if (p.val != startOfSecond.val) return false;
            p = p.next;
            startOfSecond = startOfSecond.next;
        }
        return true;
    }
}
