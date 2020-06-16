package leetcode.leetcode0xx.leetcode86;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        ListNode left = new ListNode();
        ListNode tmpLeft = left;
        ListNode right = new ListNode();
        ListNode tmpRight = right;
        while (head!=null){
            if(head.val<x){
                tmpLeft.next = head;
                tmpLeft = tmpLeft.next;
            }else{
                tmpRight.next = head;
                tmpRight = tmpRight.next;
            }
            head = head.next;
        }
        tmpLeft.next = right.next;
        tmpRight.next = null;
        return left.next;
    }
}
