package leetcode.leetcode9xx.leetcode987;

import java.util.*;

public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Stack<Node> stack = new Stack<>();
        Node rootNode = new Node(0, 1000, root);
        ArrayList<Node> list = new ArrayList<>(1000);
        stack.add(rootNode);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node);
            if (node.node.left != null) {
                Node leftNode = new Node(node.x - 1, node.y - 1, node.node.left);
                stack.push(leftNode);
            }
            if (node.node.right != null) {
                Node rightNode = new Node(node.x + 1, node.y - 1, node.node.right);
                stack.push(rightNode);
            }
        }
        list.sort(comparator);
        List<List<Integer>> ans = new LinkedList<>();
        int previousX = list.get(0).x;
        List<Integer> current = new LinkedList<>();
        for (Node node : list) {
            if (node.x == previousX) current.add(node.node.val);
            else {
                ans.add(current);
                current = new LinkedList<>();
                current.add(node.node.val);
                previousX = node.x;
            }
        }
        ans.add(current);
        return ans;
    }

    private static class Node {
        final int x, y;
        final TreeNode node;

        public Node(int x, int y, TreeNode node) {
            this.x = x;
            this.y = y;
            this.node = node;
        }

    }

    private static Comparator<Node> comparator = Comparator.comparingInt(
            a -> (a.x + 1000) << 20 | (1000 - a.y) << 10 | a.node.val
    );
}
