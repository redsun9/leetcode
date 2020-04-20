package leetcode.leetcode13xx.leetcode1305;

import leetcode.tools.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    private static void prepareForNext(Stack<StackNode> stack) {
        StackNode peek = stack.peek();
        peek.processed = true;
        if (peek.root.right != null) {
            stack.push(new StackNode(peek.root.right));
            while (stack.peek().root.left != null) {
                stack.push(new StackNode(stack.peek().root.left));
            }
        }

        while (!stack.isEmpty() && stack.peek().processed) stack.pop();
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<StackNode> first = new Stack<>();
        if (root1 != null) {
            first.push(new StackNode(root1));
            while (first.peek().root.left != null) {
                first.push(new StackNode(first.peek().root.left));
            }
        }
        Stack<StackNode> second = new Stack<>();
        if (root2 != null) {
            second.push(new StackNode(root2));
            while (second.peek().root.left != null) {
                second.push(new StackNode(second.peek().root.left));
            }
        }
        LinkedList<Integer> ans = new LinkedList<>();
        while (!first.isEmpty() || !second.isEmpty()) {
            if (!first.isEmpty() && !second.isEmpty()) {
                StackNode firstPeek = first.peek();
                StackNode secondPeek = second.peek();
                Stack<StackNode> toProcess = firstPeek.root.val < secondPeek.root.val ? first : second;
                ans.add(toProcess.peek().root.val);
                prepareForNext(toProcess);
            } else {
                Stack<StackNode> toProcess = first.isEmpty() ? second : first;
                ans.add(toProcess.peek().root.val);
                prepareForNext(toProcess);
            }
        }
        return ans;
    }

    private static class StackNode {
        TreeNode root;
        boolean processed;

        public StackNode(TreeNode root) {
            this.root = root;
        }
    }
}
