package leetcode.leetcode160;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int firstSize = 0;
        ListNode tmp = headA;
        while (tmp != null) {
            firstSize++;
            tmp = tmp.next;
        }
        int secondSize = 0;
        tmp = headB;
        while (tmp != null) {
            secondSize++;
            tmp = tmp.next;
        }
        while (firstSize > secondSize) {
            firstSize--;
            headA = headA.next;
        }
        while (secondSize > firstSize) {
            secondSize--;
            headB = headB.next;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
