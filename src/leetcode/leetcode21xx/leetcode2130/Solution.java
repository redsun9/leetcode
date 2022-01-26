package leetcode.leetcode21xx.leetcode2130;

import leetcode.tools.ListNode;

public class Solution {
    public int pairSum(ListNode head) {
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
        int ans = 0;
        while (p != null) {
            ans = Math.max(ans, p.val + startOfSecond.val);
            p = p.next;
            startOfSecond = startOfSecond.next;
        }
        return ans;
    }
}
