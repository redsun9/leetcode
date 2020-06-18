package leetcode.leetcode14xx.leetcode1485;

public class Node {
    int val;
    Node left, right, random;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}
