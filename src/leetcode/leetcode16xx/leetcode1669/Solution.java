package leetcode.leetcode16xx.leetcode1669;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ans = new ListNode(0, list1);

        ListNode tmp2 = ans;
        b -= a;
        while (a-- > 0) tmp2 = tmp2.next;
        ListNode tmp1 = tmp2;

        tmp2 = tmp2.next;
        while (b-- > 0) tmp2 = tmp2.next;

        ListNode tmp3 = list2;
        while (tmp3.next != null) tmp3 = tmp3.next;

        tmp1.next = list2;
        tmp3.next = tmp2.next;

        return ans.next;
    }
}
