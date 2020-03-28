package leetcode.leetcode19;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, final int n) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode tortoise = ans;
        ListNode hare = ans;
        for (int i = 0; i < n + 1; i++) {
            hare = hare.next;
        }
        while (hare != null) {
            tortoise = tortoise.next;
            hare = hare.next;
        }
        tortoise.next = tortoise.next.next;
        return ans.next;
    }
}
