package suggestions.infected_tree;

import leetcode.tools.TreeNode;

import java.util.IdentityHashMap;
import java.util.Stack;

import static java.lang.Math.max;

public class Solution {
    public static int recursiveSolution(TreeNode root) {
        return dfs(root)[1];
    }

    //size,dp
    private static int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] l = dfs(root.left), r = dfs(root.right);
        return new int[]{l[0] + r[0] + 1, max(0, max(l[0] - 1 + r[1], r[0] - 1 + l[1]))};
    }


    public static int nonRecursiveSolution(TreeNode root) {
        IdentityHashMap<TreeNode, Integer> sizeMap = new IdentityHashMap<>();
        IdentityHashMap<TreeNode, Integer> dpMap = new IdentityHashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (
                    node.left != null && !sizeMap.containsKey(node.left) ||
                            node.right != null && !sizeMap.containsKey(node.right)
            ) {
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            } else {
                stack.pop();
                int s1 = node.left != null ? sizeMap.get(node.left) : 0;
                int s2 = node.right != null ? sizeMap.get(node.right) : 0;
                int s = s1 + s2 + 1;
                int dp1 = node.left != null ? dpMap.get(node.left) : 0;
                int dp2 = node.right != null ? dpMap.get(node.right) : 0;
                int dp = max(0, max(s1 - 1 + dp2, s2 - 1 + dp1));
                sizeMap.put(node, s);
                dpMap.put(node, dp);
            }
        }
        return dpMap.get(root);
    }
}
