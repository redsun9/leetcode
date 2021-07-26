package leetcode.leetcode0xx.leetcode94;

import leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;


// Morris traversal
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                ans.add(root.val);
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) pre = pre.right;
                pre.right = root;
                TreeNode next = root.left;
                root.left = null;
                root = next;
            }
        }
        return ans;
    }
}
