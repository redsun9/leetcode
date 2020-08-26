package firecode;

import java.util.ArrayDeque;
import java.util.Queue;

public class DecompressTree {
    public TreeNode decompressTree(String str) {
        String[] values = str.split(",");
        if (values.length == 0 || values.length == 1 && values[0].equals("*")) return null;
        TreeNode rootNode = new TreeNode(Integer.parseInt(values[0]), null, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(rootNode);
        int i = 1;
        int n = values.length;
        while (i < n) {
            TreeNode node = queue.poll();
            if (!values[i].equals("*")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]), null, null);
                node.left = leftNode;
                queue.add(leftNode);
            }
            i++;
            if (i < n && !values[i].equals("*")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]), null, null);
                node.right = rightNode;
                queue.add(rightNode);
            }
            i++;
        }
        return rootNode;
    }
}
