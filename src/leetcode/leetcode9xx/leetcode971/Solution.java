package leetcode.leetcode9xx.leetcode971;

import leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ans = new ArrayList<>(voyage.length);
        int pos = flip(root, voyage, 0, ans);
        if (pos == voyage.length) return ans;
        else return Collections.singletonList(-1);
    }

    private static int flip(TreeNode root, int[] voyage, int pos, List<Integer> ans) {
        if (root.val != voyage[pos++]) return -1;
        if (root.left != null) {
            if (root.left.val != voyage[pos]) {
                if (root.right != null) {
                    ans.add(voyage[pos - 1]);
                    TreeNode right = root.right;
                    root.right = root.left;
                    root.left = right;
                } else return -1;
            }
            pos = flip(root.left, voyage, pos, ans);
            if (pos == -1) return -1;
        }
        if (root.right != null) {
            if (root.right.val != voyage[pos]) return -1;
            pos = flip(root.right, voyage, pos, ans);
        }
        return pos;
    }
}
