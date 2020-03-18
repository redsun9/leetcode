package leetcode.leetcode124;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int maxPathSum(TreeNode root) {
        long maxSum = Long.MIN_VALUE;
        HashMap<TreeNode, Long> subSums = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            boolean ready = true;
            Long leftLong = null;
            Long rightLong = null;
            if (peek.left != null) {
                leftLong = subSums.get(peek.left);
                if (leftLong == null) {
                    ready = false;
                    stack.push(peek.left);
                }
            }
            if (peek.right != null) {
                rightLong = subSums.get(peek.right);
                if (rightLong == null) {
                    ready = false;
                    stack.push(peek.right);
                }
            }
            if (ready) {
                long tmpMax = peek.val;
                long subSumMax = peek.val;
                if (leftLong == null || leftLong < 0) {
                    leftLong = 0L;
                }
                if (rightLong == null || rightLong < 0) {
                    rightLong = 0L;
                }
                tmpMax = tmpMax + rightLong + leftLong;
                maxSum = Long.max(tmpMax, maxSum);
                subSumMax += Long.max(rightLong, leftLong);
                subSums.put(peek, subSumMax);
                stack.pop();
            }
        }
        return (int) maxSum;
    }
}
