package help_requests.max_complete_subtree_sum;

import leetcode.tools.TreeNode;

import java.util.Stack;

// find nonempty subgraph of binary tree which is complete subtree with max sum and return its sum
// complete subtree - connected graph, exactly one node which whom have zero or two neighbours
// and all other nodes of it have exactly one or three neighbours

public class Solution2 {
    public static long nonRecursiveSolution(TreeNode root) {
        long ans = Long.MIN_VALUE;
        Stack<CalcNode> stack = new Stack<>();
        CalcNode rootCalcNode = new CalcNode(root, true);
        stack.push(rootCalcNode);

        while (!stack.isEmpty()) {
            CalcNode calcNode = stack.peek();
            boolean shouldWaitForChildren = false;

            if (calcNode.treeNode.left != null && calcNode.leftCalcNode == null) {
                CalcNode left = new CalcNode(calcNode.treeNode.left, true);
                calcNode.leftCalcNode = left;
                left.parentCalcNode = calcNode;
                stack.push(left);
                shouldWaitForChildren = true;
            }
            if (calcNode.treeNode.right != null && calcNode.rightCalcNode == null) {
                CalcNode right = new CalcNode(calcNode.treeNode.right, false);
                calcNode.rightCalcNode = right;
                right.parentCalcNode = calcNode;
                stack.push(right);
                shouldWaitForChildren = true;
            }
            if (shouldWaitForChildren) continue;

            stack.pop();
            long sumLeftRight = calcNode.treeNode.val;
            if (calcNode.leftCalcNode != null && calcNode.rightCalcNode != null) {
                sumLeftRight += Math.max(0, calcNode.leftCalcNode.sumLeftRight + calcNode.rightCalcNode.sumLeftRight);
            }

            ans = Math.max(ans, sumLeftRight);
            calcNode.sumLeftRight = sumLeftRight;
        }

        stack.push(rootCalcNode);
        while (!stack.isEmpty()) {
            CalcNode calcNode = stack.pop();
            long sumLeftParent = calcNode.treeNode.val;
            if (calcNode.leftCalcNode != null && calcNode.parentCalcNode != null) {
                sumLeftParent += Math.max(0, calcNode.leftCalcNode.sumLeftRight + (calcNode.isLeftSubtree ?
                        calcNode.parentCalcNode.sumRightParent : calcNode.parentCalcNode.sumLeftParent
                ));
            }
            ans = Math.max(ans, sumLeftParent);
            calcNode.sumLeftParent = sumLeftParent;

            long sumRightParent = calcNode.treeNode.val;
            if (calcNode.rightCalcNode != null && calcNode.parentCalcNode != null) {
                sumRightParent += Math.max(0, calcNode.rightCalcNode.sumLeftRight + (calcNode.isLeftSubtree ?
                        calcNode.parentCalcNode.sumRightParent : calcNode.parentCalcNode.sumLeftParent
                ));
            }
            ans = Math.max(ans, sumRightParent);
            calcNode.sumRightParent = sumRightParent;

            if (calcNode.leftCalcNode != null) stack.push(calcNode.leftCalcNode);
            if (calcNode.rightCalcNode != null) stack.push(calcNode.rightCalcNode);
        }

        return ans;
    }

    private static class CalcNode {
        TreeNode treeNode;
        boolean isLeftSubtree;
        CalcNode leftCalcNode, rightCalcNode, parentCalcNode;
        long sumLeftRight, sumLeftParent, sumRightParent;

        CalcNode(TreeNode treeNode, boolean isLeftSubtree) {
            this.treeNode = treeNode;
            this.isLeftSubtree = isLeftSubtree;
        }
    }
}
