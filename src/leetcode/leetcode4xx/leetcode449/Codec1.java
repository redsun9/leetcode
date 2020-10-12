package leetcode.leetcode4xx.leetcode449;

import leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
    User level order traversal
 */
public class Codec1 {
    private static Integer parse(String str) {
        if (str.isEmpty()) return null;
        else return Integer.parseInt(str);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        int lastPos = 0;
        int curPos = 0;
        int endPos = 0;
        while (curPos++ <= lastPos) {
            root = queue.poll();
            sb.append(',');
            if (root != null) {
                sb.append(root.val);
                queue.add(root.left);
                queue.add(root.right);
                if (root.right != null) lastPos = endPos + 2;
                else if (root.left != null) lastPos = endPos + 1;
                endPos += 2;
            }
        }
        return sb.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] parts = data.split(",");
        Integer[] values = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            values[i] = parse(parts[i]);
        }
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
            if (i < n && values[i] != null) {
                TreeNode rightNode = new TreeNode(values[i]);
                node.right = rightNode;
                queue.add(rightNode);
            }
            i++;
        }
        return rootNode;
    }
}
