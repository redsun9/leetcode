package leetcode.leetcode20xx.leetcode2058;

import leetcode.tools.ListNode;

public class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int idx = 0, first = -1, last = -1, minDist = Integer.MAX_VALUE;
        ListNode p = head, q = p != null ? p.next : null, r = q != null ? q.next : null;
        while (r != null) {
            if (p.val < q.val && q.val > r.val || p.val > q.val && q.val < r.val) {
                if (first == -1) first = idx;
                else minDist = Math.min(minDist, idx - last);
                last = idx;
            }
            p = q;
            q = r;
            r = r.next;
            idx++;
        }
        return minDist != Integer.MAX_VALUE ? new int[]{minDist, last - first} : new int[]{-1, -1};
    }
}
