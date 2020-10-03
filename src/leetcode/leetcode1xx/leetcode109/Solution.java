package leetcode.leetcode1xx.leetcode109;

import leetcode.tools.ListNode;
import leetcode.tools.TreeNode;

//https://en.wikipedia.org/wiki/Day%E2%80%93Stout%E2%80%93Warren_algorithm
public class Solution {
    private static void compress(TreeNode root, int m) {
        TreeNode tmp = root.right;
        while (m-- != 0) {
            TreeNode old = tmp;
            tmp = tmp.right;
            root.right = tmp;
            old.right = tmp.left;
            tmp.left = old;
            root = tmp;
            tmp = tmp.right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = new TreeNode();
        TreeNode tmp = root;
        int n = 0;
        while (head != null) {
            n++;
            tmp.right = new TreeNode(head.val);
            tmp = tmp.right;
            head = head.next;
        }

        int m = Integer.highestOneBit(n + 1) - 1;
        compress(root, n - m);
        for (m = m / 2; m != 0; m /= 2) compress(root, m);
        return root.right;
    }
}
