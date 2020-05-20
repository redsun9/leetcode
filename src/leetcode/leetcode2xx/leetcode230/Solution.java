package leetcode.leetcode2xx.leetcode230;

import leetcode.tools.TreeNode;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        MyNode head = new MyNode(root);
        return head.kthSmallest(k);
    }


    private static class MyNode {
        private TreeNode node;
        private MyNode left, right;
        private int size;

        private MyNode(TreeNode node) {
            this.node = node;
            if (node.left != null) left = new MyNode(node.left);
            if (node.right != null) right = new MyNode(node.right);
            this.size = 1 + (left != null ? left.size : 0) + (right != null ? right.size : 0);
        }

        public int kthSmallest(int k) {
            if (left != null) {
                if (left.size >= k) return left.kthSmallest(k);
                else k -= left.size;
            }
            if (k == 1) return node.val;
            return right.kthSmallest(k - 1);
        }
    }
}
