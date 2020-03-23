package leetcode.leetcode25;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (k == 1) return head;
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode prevGroup = ans, nextGroup;
        ListNode tmp = null;
        while (true) {
            int counter = 0;
            tmp = prevGroup;
            while (counter != k && tmp.next != null) {
                tmp = tmp.next;
                counter++;
            }

            if (counter == k) {
                nextGroup = tmp.next;
                Pair reverse = reverse(prevGroup.next, k);
                prevGroup.next = reverse.start;
                reverse.end.next = nextGroup;
                prevGroup = reverse.end;
                if (nextGroup == null) break;
                ;
            } else {
                break;
            }
        }
        return ans.next;
    }

    private static Pair reverse(ListNode head, int k) {
        if (k == 2) {
            ListNode b = head.next;
            b.next = head;
            head.next = null;
            return new Pair(b, head);
        } else {
            k = k - 2;
            ListNode p = head;
            ListNode q = p.next;
            ListNode r = q.next;
            p.next = null;
            do {
                q.next = p;
                p = q;
                q = r;
                r = r.next;
                k--;
            } while (k > 0);
            q.next = p;
            return new Pair(q, head);
        }
    }
}
