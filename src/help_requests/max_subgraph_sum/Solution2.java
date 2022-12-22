package help_requests.max_subgraph_sum;

import leetcode.tools.TreeNode;

import java.util.Stack;

public class Solution2 {
    public static long nonRecursiveSolution(TreeNode root) {
        long ans = Long.MIN_VALUE;
        Stack<CalcNode> stack = new Stack<>();
        stack.push(new CalcNode(root));

        while (!stack.isEmpty()) {
            CalcNode calcNode = stack.peek();
            boolean shouldWaitForChildren = false;

            if (calcNode.treeNode.left != null && calcNode.leftCalcNode == null) {
                CalcNode left = new CalcNode(calcNode.treeNode.left);
                calcNode.leftCalcNode = left;
                stack.push(left);
                shouldWaitForChildren = true;
            }
            if (calcNode.treeNode.right != null && calcNode.rightCalcNode == null) {
                CalcNode right = new CalcNode(calcNode.treeNode.right);
                calcNode.rightCalcNode = right;
                stack.push(right);
                shouldWaitForChildren = true;
            }
            if (shouldWaitForChildren) continue;

            stack.pop();
            long tmp = calcNode.treeNode.val;
            if (calcNode.leftCalcNode != null && calcNode.leftCalcNode.maxSumWithThisNode > 0)
                tmp += calcNode.leftCalcNode.maxSumWithThisNode;
            if (calcNode.rightCalcNode != null && calcNode.rightCalcNode.maxSumWithThisNode > 0)
                tmp += calcNode.rightCalcNode.maxSumWithThisNode;
            ans = Math.max(ans, tmp);
            calcNode.maxSumWithThisNode = tmp;
        }
        return ans;
    }

    private static class CalcNode {
        CalcNode leftCalcNode, rightCalcNode;
        TreeNode treeNode;
        long maxSumWithThisNode;

        CalcNode(TreeNode treeNode) {
            this.treeNode = treeNode;
        }
    }
}
