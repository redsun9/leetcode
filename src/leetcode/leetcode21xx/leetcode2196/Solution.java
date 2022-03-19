package leetcode.leetcode21xx.leetcode2196;

import leetcode.tools.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        HashSet<Integer> leafs = new HashSet<>();
        for (int[] description : descriptions) {
            int u = description[0], v = description[1];
            TreeNode parent = nodes.computeIfAbsent(u, TreeNode::new);
            TreeNode child = nodes.computeIfAbsent(v, TreeNode::new);
            if (description[2] == 0) parent.right = child;
            else parent.left = child;
            leafs.add(v);
        }
        for (Map.Entry<Integer, TreeNode> entry : nodes.entrySet()) {
            if (leafs.contains(entry.getKey())) continue;
            return entry.getValue();
        }
        return null;
    }
}
