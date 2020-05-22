package leetcode.leetcode8xx.leetcode872;

import leetcode.tools.TreeNode;

import java.util.LinkedList;
import java.util.List;

//generating sequence
public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new LinkedList<>();
        List<Integer> seq2 = new LinkedList<>();
        getLeaves(root1, seq1);
        getLeaves(root2, seq2);
        return seq1.equals(seq2);
    }

    private static void getLeaves(TreeNode root, List<Integer> ans) {
        if (root.left == null && root.right == null) {
            ans.add(root.val);
        } else {
            if (root.left != null) getLeaves(root.left, ans);
            if (root.right != null) getLeaves(root.right, ans);
        }
    }
}
