package leetcode.leetcode3xx.leetcode366;

import leetcode.tools.TreeNode;

import java.util.*;

@SuppressWarnings("ConstantConditions")
public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Map<TreeNode, Integer> outCount = new IdentityHashMap<>();
        Map<TreeNode, TreeNode> parentMap = new IdentityHashMap<>();
        Queue<TreeNode> q1 = new ArrayDeque<>();

        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> prev = new ArrayList<>();

        q1.add(root);
        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            if (node.left == null && node.right == null) prev.add(node);
            if (node.left != null) {
                outCount.compute(node, (k, v) -> v == null ? 1 : v + 1);
                parentMap.put(node.left, node);
                q1.add(node.left);
            }
            if (node.right != null) {
                outCount.compute(node, (k, v) -> v == null ? 1 : v + 1);
                parentMap.put(node.right, node);
                q1.add(node.right);
            }
        }
        while (true) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> subAns = new ArrayList<>(prev.size());
            for (TreeNode v : prev) {
                subAns.add(v.val);
                TreeNode parent = parentMap.get(v);
                if (parent != null) {
                    if (outCount.compute(parent, (k, val) -> val - 1) == 0) next.add(parent);
                }
            }
            ans.add(subAns);
            if (next.isEmpty()) return ans;
            prev = next;
        }
    }
}
