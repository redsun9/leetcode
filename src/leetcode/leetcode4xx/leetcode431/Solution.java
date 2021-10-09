package leetcode.leetcode4xx.leetcode431;


import leetcode.tools.TreeNode;

import java.util.*;

public class Solution {
    /**
     * @param root: binary tree
     * @return N-ary tree
     */
    public UndirectedGraphNode decode(TreeNode root) {
        if (root == null) return null;
        return deserializeNaryTree(serializeBst(root));
    }

    /**
     * @param root: N-ary tree
     * @return binary tree
     */
    public TreeNode encode(UndirectedGraphNode root) {
        if (root == null) return null;
        return deserializeBst(serializeNaryTree(root));
    }


    private static List<Integer> serializeBst(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int lastNonNull = 1;
        ans.add(root.val);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                ans.add(poll.left.val);
                queue.add(poll.left);
                lastNonNull = ans.size();
            } else ans.add(null);
            if (poll.right != null) {
                ans.add(poll.right.val);
                queue.add(poll.right);
                lastNonNull = ans.size();
            } else ans.add(null);
        }
        return ans.subList(0, lastNonNull);
    }

    private static List<Integer> serializeNaryTree(UndirectedGraphNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        int lastNonNull = 1;
        ans.add(root.label);
        queue.add(root);
        while (!queue.isEmpty()) {
            UndirectedGraphNode poll = queue.poll();
            if (!poll.neighbors.isEmpty()) {
                queue.addAll(poll.neighbors);
                for (UndirectedGraphNode neighbor : poll.neighbors) ans.add(neighbor.label);
                lastNonNull = ans.size();
            }
            ans.add(null);
        }
        return ans.subList(0, lastNonNull);
    }

    @SuppressWarnings("ConstantConditions")
    private static TreeNode deserializeBst(List<Integer> list) {
        TreeNode rootNode = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(rootNode);
        int i = 1;
        int n = list.size();
        while (i < n) {
            TreeNode node = queue.poll();
            if (list.get(i) != null) {
                TreeNode leftNode = new TreeNode(list.get(i));
                node.left = leftNode;
                queue.add(leftNode);
            }
            i++;
            if (i < n && list.get(i) != null) {
                TreeNode rightNode = new TreeNode(list.get(i));
                node.right = rightNode;
                queue.add(rightNode);
            }
            i++;
        }
        return rootNode;
    }

    @SuppressWarnings("ConstantConditions")
    private static UndirectedGraphNode deserializeNaryTree(List<Integer> list) {
        UndirectedGraphNode rootNode = new UndirectedGraphNode(list.get(0));
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.add(rootNode);
        int i = 1;
        int n = list.size();
        while (i < n) {
            UndirectedGraphNode node = queue.poll();
            while (i < n && list.get(i) != null) {
                UndirectedGraphNode v = new UndirectedGraphNode(list.get(i));
                node.neighbors.add(v);
                queue.add(v);
                i++;
            }
            i++;
        }
        return rootNode;
    }
}
