package leetcode.leetcode1xx.leetcode141;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode hare = head.next;
        ListNode tortoise = head;
        while (hare != null) {
            hare = hare.next;
            if (hare == null) return false;
            hare = hare.next;
            tortoise = tortoise.next;
            if (tortoise == hare) return true;
        }
        return false;
    }
}
