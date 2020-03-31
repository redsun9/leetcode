package leetcode.leetcode113;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        Stack<CustomNode> stack = new Stack<>();
        stack.push(new CustomNode(root, null, 0));
        while (!stack.isEmpty()) {
            CustomNode pop = stack.pop();
            if (pop.node.left != null || pop.node.right != null) {
                if (pop.node.left != null) stack.push(new CustomNode(pop.node.left, pop, pop.sum + pop.node.val));
                if (pop.node.right != null) stack.push(new CustomNode(pop.node.right, pop, pop.sum + pop.node.val));
            } else {
                if (pop.sum + pop.node.val == sum) ans.add(pop.printPath());
            }
        }
        return ans;
    }

    private static class CustomNode {
        TreeNode node;
        CustomNode parent;
        int sum;

        public CustomNode(TreeNode node, CustomNode parent, int sum) {
            this.node = node;
            this.parent = parent;
            this.sum = sum;
        }

        List<Integer> printPath() {
            LinkedList<Integer> list = new LinkedList<>();
            CustomNode tmp = this;
            while (tmp != null) {
                list.addFirst(tmp.node.val);
                tmp = tmp.parent;
            }
            return list;
        }
    }
}
