package leetcode.leetcode11xx.leetcode1145;

import leetcode.tools.TreeNode;

public class Solution {
    @SuppressWarnings("ConstantConditions")
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        //we must calculate all subtrees (max possible 3)
        Pair pair = countSubtrees(root, x);
        int a = pair.nLeft;
        int b = pair.nRight;
        int c = n - a - b - 1;
        return a > b + c + 1 || b > a + c + 1 || c > a + b + 1;
    }

    private static Pair countSubtrees(TreeNode root, int x) {
        if (root.val == x) return new Pair(countNodes(root.left), countNodes(root.right));
        if (root.left != null) {
            Pair pair = countSubtrees(root.left, x);
            if (pair != null) return pair;
        }
        if (root.right != null) {
            return countSubtrees(root.right, x);
        }
        return null;
    }

    private static int countNodes(TreeNode root) {
        if (root == null) return 0;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static class Pair {
        int nLeft, nRight;

        public Pair(int nLeft, int nRight) {
            this.nLeft = nLeft;
            this.nRight = nRight;
        }
    }
}
