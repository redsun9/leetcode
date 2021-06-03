package leetcode.leetcode5xx.leetcode501;

import leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int maxCounter = 0;
        int prev = Integer.MIN_VALUE;
        int currentCounter = 0;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev == root.val) currentCounter++;
            else currentCounter = 1;
            if (currentCounter > maxCounter) {
                maxCounter = currentCounter;
                list.clear();
            }
            if (currentCounter == maxCounter) list.add(root.val);
            prev = root.val;
            root = root.right;
        }
        int[] ans = new int[list.size()];
        int pos = 0;
        for (Integer val : list) ans[pos++] = val;
        return ans;
    }
}
