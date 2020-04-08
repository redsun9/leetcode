package leetcode.leetcode8xx.leetcode876;

public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            hare = hare.next;
            hare = hare.next;
            tortoise = tortoise.next;
        }
        return tortoise;
    }
}
