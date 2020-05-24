package leetcode.leetcode10xx.leetcode1019;

import leetcode.tools.ListNode;

import java.util.Stack;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Pair pair = reverseList(head);
        int[] ans = new int[pair.numberOfNodes];
        if (pair.numberOfNodes <= 1) return ans;
        Stack<Integer> stack = new Stack<>();
        stack.push(pair.head.val);
        ListNode tmp = pair.head.next;
        for (int i = pair.numberOfNodes - 2; i >= 0; i--, tmp = tmp.next) {
            while (!stack.isEmpty() && stack.peek() <= tmp.val) stack.pop();
            if (!stack.isEmpty()) ans[i] = stack.peek();
            stack.push(tmp.val);
        }
        return ans;
    }

    private static Pair reverseList(ListNode head) {
        if (head == null) return new Pair(null, 0);
        if (head.next == null) return new Pair(head, 1);
        int count = 0;
        ListNode p = null;
        ListNode q = head;

        while (q != null) {
            count++;
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return new Pair(p, count);
    }

    private static class Pair {
        ListNode head;
        int numberOfNodes;

        public Pair(ListNode head, int numberOfNodes) {
            this.head = head;
            this.numberOfNodes = numberOfNodes;
        }
    }
}
