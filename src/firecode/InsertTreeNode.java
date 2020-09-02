package firecode;

public class InsertTreeNode {
    public TreeNode insert(TreeNode root, int data) {
        TreeNode node = new TreeNode(data, null, null);
        if (root == null) return node;
        TreeNode tmp = root;
        while (true) {
            if (tmp.data >= data) {
                if (tmp.left != null) tmp = tmp.left;
                else {
                    tmp.left = node;
                    break;
                }
            } else {
                if (tmp.right != null) tmp = tmp.right;
                else {
                    tmp.right = node;
                    break;
                }
            }
        }
        return root;
    }
}
