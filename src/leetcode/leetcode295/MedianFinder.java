package leetcode.leetcode295;

public class MedianFinder {
    private TreeNode tree;

    public void addNum(int num) {
        if (tree == null) {
            tree = new TreeNode(num);
        } else {
            tree.insert(num);
        }
    }

    public double findMedian() {
        if ((tree.total & 1) != 0) {
            return tree.getNth((tree.total >> 1) + 1);
        } else {
            return tree.getNth((tree.total >> 1) + 1) * 0.5 + tree.getNth(tree.total >> 1) * 0.5;
        }
    }

    private static class TreeNode {
        TreeNode left, right;
        int val, total = 1, dup = 1;

        public TreeNode(int v) {
            val = v;
        }

        public void insert(int num) {
            this.total++;
            if (this.val == num) {
                this.dup++;
            } else if (this.val > num) {
                if (this.left == null) {
                    this.left = new TreeNode(num);
                } else {
                    this.left.insert(num);
                }
            } else {
                if (this.right == null) {
                    this.right = new TreeNode(num);
                } else {
                    this.right.insert(num);
                }
            }
        }

        public int getNth(int n) {
            if (this.left != null) {
                if (this.left.total >= n) {
                    return this.left.getNth(n);
                }
                n -= this.left.total;
            }
            if (this.dup >= n) return this.val;
            //noinspection ConstantConditions
            return this.right.getNth(n - this.dup);
        }
    }
}
