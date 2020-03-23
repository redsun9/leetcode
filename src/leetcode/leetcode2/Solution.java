package leetcode.leetcode2;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up = 0;
        ListNode ans = new ListNode(0);
        ListNode tmp = ans;
        while (l1 != null || l2 != null || up != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + up;
            tmp.next = new ListNode(sum % 10);
            up = sum / 10;
            tmp = tmp.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return ans.next;
    }
}
