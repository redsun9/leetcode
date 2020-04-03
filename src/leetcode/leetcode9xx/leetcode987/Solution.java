package leetcode.leetcode9xx.leetcode987;

import java.util.*;

public class Solution {
    private static final int MASK_X = ((1 << 11) - 1) << 20;
    private static final int MASK_Y = ((1 << 10) - 1) << 10;
    private static final int MASK_VAL = (1 << 10) - 1;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<TreeNode> list = new ArrayList<>(1000);
        root.val = f(1000, 0, root.val);
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node);
            int x = (node.val & MASK_X) >> 20;
            int y = (node.val & MASK_Y) >> 10;
            TreeNode left = node.left;
            if (left != null) {
                left.val = f(x - 1, y + 1, left.val);
                stack.push(left);
            }
            TreeNode right = node.right;
            if (right != null) {
                right.val = f(x + 1, y + 1, right.val);
                stack.push(right);
            }
        }
        list.sort(Comparator.comparingInt(x -> x.val));

        List<List<Integer>> ans = new LinkedList<>();
        int prevX = list.get(0).val & MASK_X;
        LinkedList<Integer> sublist = new LinkedList<>();
        for (TreeNode node : list) {
            int curX = node.val & MASK_X;
            int val = node.val & MASK_VAL;
            if (curX == prevX) {
                sublist.add(val);
            } else {
                ans.add(sublist);
                sublist = new LinkedList<>();
                sublist.add(val);
                prevX = curX;
            }
        }
        ans.add(sublist);
        return ans;
    }

    private static int f(int x, int y, int val) {
        return x << 20 | y << 10 | val;
    }
}
