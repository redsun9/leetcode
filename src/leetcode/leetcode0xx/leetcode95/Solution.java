package leetcode.leetcode0xx.leetcode95;

import leetcode.tools.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.emptyList();
        return generateTrees(1, n + 1);
    }

    private List<TreeNode> generateTrees(int l, int r) {
        if (l == r) return Collections.singletonList(null);
        LinkedList<TreeNode> ans = new LinkedList<>();
        for (int i = l; i < r; i++) {
            List<TreeNode> leftTrees = generateTrees(l, i);
            List<TreeNode> rightTrees = generateTrees(i + 1, r);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTree;
                    treeNode.right = rightTree;
                    ans.add(treeNode);
                }
            }
        }
        return ans;
    }
}
