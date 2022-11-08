package leetcode.leetcode24xx.leetcode2458;

import leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = getN(root), m = queries.length;
        int[] h = new int[n + 1], vals = new int[n + 1];
        getHeights(root, h);
        getValues(root, h, vals);
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = vals[queries[i]];
        }
        return ans;
    }

    private static int getN(TreeNode root) {
        int n = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            n = Math.max(n, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return n;
    }

    private static void getHeights(TreeNode root, int[] h) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (h[node.val] == 0) {
                h[node.val] = -1;
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            } else {
                h[node.val] = 0;
                if (node.left != null) h[node.val] = Math.max(h[node.val], h[node.left.val] + 1);
                if (node.right != null) h[node.val] = Math.max(h[node.val], h[node.right.val] + 1);
                stack.pop();
            }
        }
    }

    private static void getValues(TreeNode root, int[] h, int[] vals) {
        Queue<Args> queue = new ArrayDeque<>();
        queue.add(new Args(root, 0, -1));
        while (!queue.isEmpty()) {
            Args args = queue.poll();
            root = args.root;
            vals[root.val] = args.altH;
            if (root.left != null) {
                int rightSibling = root.right != null ? h[root.right.val] : -1;
                queue.offer(new Args(root.left, maxOf(rightSibling + args.parentDepth + 2, args.altH), args.parentDepth + 1));
            }
            if (root.right != null) {
                int leftSibling = root.left != null ? h[root.left.val] : -1;
                queue.offer(new Args(root.right, maxOf(leftSibling + args.parentDepth + 2, args.altH), args.parentDepth + 1));
            }
        }
    }

    private record Args(TreeNode root, int altH, int parentDepth) {
    }

    private static int maxOf(int a, int b) {
        return Math.max(a, b);
    }

    private static int maxOf(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
