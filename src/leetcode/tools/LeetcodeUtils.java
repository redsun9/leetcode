package leetcode.tools;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("ConstantConditions")
public class LeetcodeUtils {
    public static TreeNode initializeTree(Integer[] values) {
        TreeNode rootNode = new TreeNode(values[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(rootNode);
        int i = 1;
        int n = values.length;
        while (i < n) {
            TreeNode node = queue.poll();
            if (values[i] != null) {
                TreeNode leftNode = new TreeNode(values[i]);
                node.left = leftNode;
                queue.add(leftNode);
            }
            i++;
            if (values[i] != null) {
                TreeNode rightNode = new TreeNode(values[i]);
                node.right = rightNode;
                queue.add(rightNode);
            }
            i++;
        }
        return rootNode;
    }

    public static ListNode initializeList(int[] values) {
        ListNode node = null;
        for (int i = values.length - 1; i >= 0; i--) {
            node = new ListNode(values[i], node);
        }
        return node;
    }
}
