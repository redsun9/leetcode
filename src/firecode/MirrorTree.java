package firecode;

public class MirrorTree {
    public TreeNode mirror(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = mirror(root.left);
        root.left = mirror(root.right);
        root.right = tmp;
        return root;
    }
}
