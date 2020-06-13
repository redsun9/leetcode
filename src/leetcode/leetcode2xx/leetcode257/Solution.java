package leetcode.leetcode2xx.leetcode257;

import leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        if (root == null) return ans;
        List<StringBuilder> btp = btp(root);
        for (StringBuilder sb : btp) ans.add(sb.toString());
        return ans;
    }

    private static List<StringBuilder> btp(TreeNode root) {
        if (root.left == null && root.right == null)
            return Collections.singletonList(new StringBuilder(Integer.toString(root.val)));
        else if (root.left == null) {
            List<StringBuilder> btp = btp(root.right);
            btp.forEach(sb -> sb.insert(0, root.val + "->"));
            return btp;
        } else if (root.right == null) {
            List<StringBuilder> btp = btp(root.left);
            btp.forEach(sb -> sb.insert(0, root.val + "->"));
            return btp;
        } else {
            List<StringBuilder> left = btp(root.left);
            List<StringBuilder> right = btp(root.right);
            List<StringBuilder> ans = new ArrayList<>(left.size() + right.size());
            for (StringBuilder sb : left) ans.add(sb.insert(0, root.val + "->"));
            for (StringBuilder sb : right) ans.add(sb.insert(0, root.val + "->"));
            return ans;
        }
    }
}
