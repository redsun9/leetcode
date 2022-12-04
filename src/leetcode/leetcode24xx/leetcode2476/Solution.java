package leetcode.leetcode24xx.leetcode2476;

import leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> nodeValues = getAllNodeValues(root);
        List<List<Integer>> ans = new ArrayList<>(queries.size());
        for (Integer query : queries) {
            int idx = Collections.binarySearch(nodeValues, query);
            if (idx >= 0) ans.add(List.of(nodeValues.get(idx), nodeValues.get(idx)));
            else {
                idx = -idx - 1;
                ans.add(List.of(
                        idx - 1 >= 0 ? nodeValues.get(idx - 1) : -1,
                        idx < nodeValues.size() ? nodeValues.get(idx) : -1
                ));
            }
        }
        return ans;
    }

    private static List<Integer> getAllNodeValues(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            node = stack.pop();
            ans.add(node.val);
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return ans;
    }
}
