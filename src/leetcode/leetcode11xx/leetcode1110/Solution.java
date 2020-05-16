package leetcode.leetcode11xx.leetcode1110;

import leetcode.tools.TreeNode;

import java.util.*;

public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        int n = toDelete.length;
        if (n == 0) return Collections.singletonList(root);
        HashSet<TreeNode> forest = new HashSet<>();
        forest.add(root);
        HashMap<Integer, TreeNode> idToNode = new HashMap<>();
        HashMap<Integer, TreeNode> idToParent = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            idToNode.put(node.val, node);
            if (node.right != null) {
                queue.add(node.right);
                idToParent.put(node.right.val, node);
            }
            if (node.left != null) {
                queue.add(node.left);
                idToParent.put(node.left.val, node);
            }
        }
        for (int a : toDelete) {
            TreeNode node = idToNode.remove(a);
            forest.remove(node);
            TreeNode parent = idToParent.remove(a);
            if (parent != null) {
                if (parent.left == node) {
                    idToParent.remove(parent.left.val);
                    parent.left = null;
                }
                if (parent.right == node) {
                    idToParent.remove(parent.right.val);
                    parent.right = null;
                }
            }
            if (node.left != null) forest.add(node.left);
            if (node.right != null) forest.add(node.right);
        }
        return new ArrayList<>(forest);
    }
}
