package leetcode.leetcode3xx.leetcode315;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> ans = new LinkedList<>();
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, 0);
        }
        return ans;
    }


    private static class TreeNode {
        TreeNode left, right;
        int val, sum, dup = 1;

        public TreeNode(int v, int s) {
            val = v;
            sum = s;
        }
    }

    private TreeNode insert(int num, TreeNode node, LinkedList<Integer> ans, int preSum) {
        if (node == null) {
            node = new TreeNode(num, 0);
            ans.addFirst(preSum);
        } else if (node.val == num) {
            node.dup++;
            ans.addFirst(preSum + node.sum);
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, preSum);
        } else {
            node.right = insert(num, node.right, ans, preSum + node.dup + node.sum);
        }
        return node;
    }
}
