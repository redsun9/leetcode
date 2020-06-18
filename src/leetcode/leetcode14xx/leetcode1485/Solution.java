package leetcode.leetcode14xx.leetcode1485;

// without extra memory
public class Solution {
    public Node cloneTree(Node root) {
        if (root == null) return null;
        first(root);
        Node ans = root.left;
        second(root);
        third(root);
        return ans;
    }

    //a,l,r -> (a,a',r),(a,l,r)
    private static void first(Node root) {
        if (root == null) return;
        Node copy = new Node(root.val);
        copy.left = root.left;
        copy.right = root.right;
        root.left = copy;
        first(copy.left);
        first(copy.right);
    }

    //set random for copies
    private static void second(Node root) {
        if (root == null) return;
        if (root.random != null) root.left.random = root.random.left;
        second(root.left.left);
        second(root.left.right);
    }

    // (a,a',r),(a',l,r) -> (a,l,r),(a',l',r')
    private static void third(Node root) {
        if (root == null) return;
        Node left = root.left.left;
        root.left.left = left != null ? left.left : null;
        root.left.right = root.right != null ? root.right.left : null;
        root.left = left;
        third(root.left);
        third(root.right);
    }
}
