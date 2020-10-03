package leetcode.leetcode1xx.leetcode109;

import leetcode.tools.ListNode;
import leetcode.tools.TreeNode;

// find middle of LinkedList part by Floyd'd hare -and-tortoise algorithm

public class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return dfs(head, null);
    }

    private TreeNode dfs(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode tortoise = head, hare = head;
        while (hare != tail && hare.next != tail) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return new TreeNode(tortoise.val, dfs(head, tortoise), dfs(tortoise.next, tail));
    }
}
