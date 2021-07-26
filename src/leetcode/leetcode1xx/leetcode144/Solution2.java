package leetcode.leetcode1xx.leetcode144;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while (root != null) {
            ans.add(root.val);
            if (root.left == null) root = root.right;
            else {
                TreeNode pre = root.left;
                while (pre.right != null) pre = pre.right;
                pre.right = root.right;
                root = root.left;
            }
        }
        return ans;
    }
}
