package leetcode.leetcode9xx.leetcode968;

import leetcode.tools.TreeNode;

public class Solution {

    public int minCameraCover(TreeNode root) {
        SubAnswer subAnswer = subMin(root);
        return subAnswer.val + (subAnswer.distFromCam > 1 ? 1 : 0);
    }

    private static SubAnswer subMin(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new SubAnswer(0, 2);
        } else if (root.left == null) {
            SubAnswer right = subMin(root.right);
            if (right.distFromCam >= 2) return new SubAnswer(right.val + 1, 0);
            else return new SubAnswer(right.val, right.distFromCam + 1);
        } else if (root.right == null) {
            SubAnswer left = subMin(root.left);
            if (left.distFromCam >= 2) return new SubAnswer(left.val + 1, 0);
            else return new SubAnswer(left.val, left.distFromCam + 1);
        } else {
            SubAnswer left = subMin(root.left);
            SubAnswer right = subMin(root.right);
            return new SubAnswer(
                    left.val + right.val + (left.distFromCam >= 2 || right.distFromCam >= 2 ? 1 : 0),
                    (left.distFromCam >= 2 || right.distFromCam >= 2) ? 0 : (Math.min(left.distFromCam, right.distFromCam) + 1)
            );
        }
    }

    private static class SubAnswer {
        int val;
        int distFromCam;

        public SubAnswer(int val, int distFromCam) {
            this.val = val;
            this.distFromCam = distFromCam;
        }
    }
}
