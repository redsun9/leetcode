package leetcode.leetcode22xx.leetcode2236;

import leetcode.tools.TreeNode;

public class Solution {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
