package help_requests.max_complete_subtree_sum;

import leetcode.tools.TreeNode;

import java.util.stream.LongStream;

public class Solution {

    public static long RecursiveSolution(TreeNode root) {
        return new CalcNode(root).dfs();
    }


    private static class CalcNode {
        TreeNode node;
        CalcNode left, right, parent;
        boolean isLeftSubtree;
        Long leftRight, leftParent, rightParent;

        CalcNode(TreeNode node) {
            this.node = node;
        }

        private long dfs() {
            return LongStream.of(
                    this.leftRight(), this.leftParent(), this.rightParent(),
                    this.left != null ? this.left.dfs() : Long.MIN_VALUE,
                    this.right != null ? this.right.dfs() : Long.MIN_VALUE
            ).max().getAsLong();
        }

        private long leftRight() {
            if (this.leftRight != null) return this.leftRight;
            this.addLinks();
            this.leftRight = (long) this.node.val;
            if (this.left != null && this.right != null)
                this.leftRight += Math.max(0, this.left.leftRight() + this.right.leftRight());
            return this.leftRight;
        }

        private long leftParent() {
            if (this.leftParent != null) return this.leftParent;
            this.leftParent = (long) this.node.val;
            if (this.left != null && this.parent != null) this.leftParent += Math.max(0, this.left.leftRight() +
                    (this.isLeftSubtree ? this.parent.rightParent() : this.parent.leftParent()));
            return this.leftRight;
        }

        private long rightParent() {
            if (this.rightParent != null) return this.rightParent;
            this.rightParent = (long) this.node.val;
            if (this.right != null && this.parent != null) this.rightParent += Math.max(0, this.right.leftRight() +
                    (this.isLeftSubtree ? this.parent.rightParent() : this.parent.leftParent()));
            return this.rightParent;
        }

        private void addLinks() {
            if (this.node.left != null) {
                this.left = new CalcNode(this.node.left);
                this.left.parent = this;
                this.left.isLeftSubtree = true;
            }
            if (this.node.right != null) {
                this.right = new CalcNode(this.node.right);
                this.right.parent = this;
                this.right.isLeftSubtree = false;
            }
        }
    }
}
