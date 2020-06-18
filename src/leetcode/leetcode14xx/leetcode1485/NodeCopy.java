package leetcode.leetcode14xx.leetcode1485;

public class NodeCopy {
    int val;
    NodeCopy left, right, random;

    public NodeCopy() {
    }

    public NodeCopy(int val) {
        this.val = val;
    }

    public NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}
