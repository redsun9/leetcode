package leetcode.leetcode3xx.leetcode369;

import leetcode.tools.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("ConstantConditions")
public class Solution {
    /**
     * @param head: the first Node
     * @return the answer after plus one
     */
    public ListNode plusOne(ListNode head) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        head = ans;
        while (head != null) {
            stack.addLast(head);
            head = head.next;
        }
        int over = 1;
        while (over != 0) {
            head = stack.pollLast();
            over += head.val;
            head.val = over % 10;
            over /= 10;
        }

        return ans.val == 0 ? ans.next : ans;
    }
}
