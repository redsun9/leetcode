package leetcode.leetcode8xx.leetcode872;

import leetcode.tools.TreeNode;

import java.util.Stack;

//using tree iterator
public class Solution2 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        BSTIterator it1 = new BSTIterator(root1);
        BSTIterator it2 = new BSTIterator(root2);
        while (it1.hasNext() && it2.hasNext()) {
            TreeNode first = it1.next();
            while (!(first.left == null && first.right == null) && it1.hasNext()) first = it1.next();
            TreeNode second = it2.next();
            while (!(second.left == null && second.right == null) && it2.hasNext()) second = it2.next();
            if (
                    ((first.left == null && first.right == null) != (second.left == null && second.right == null))
                            || (first.left == null && first.right == null && first.val != second.val)
            ) return false;
        }
        if (it1.hasNext()) {
            TreeNode first = it1.next();
            while (!(first.left == null && first.right == null) && it1.hasNext()) first = it1.next();
            return !(first.left == null && first.right == null);
        }
        if (it2.hasNext()) {
            TreeNode second = it2.next();
            while (!(second.left == null && second.right == null) && it2.hasNext()) second = it2.next();
            return !(second.left == null && second.right == null);
        }
        return !it1.hasNext() && !it2.hasNext();
    }

    private static class BSTIterator {
        private Stack<TreeNode> stack = new Stack<TreeNode>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public TreeNode next() {
            TreeNode tmpNode = stack.pop();
            pushAll(tmpNode.right);
            return tmpNode;
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
