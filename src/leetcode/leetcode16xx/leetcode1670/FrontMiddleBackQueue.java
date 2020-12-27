package leetcode.leetcode16xx.leetcode1670;

public class FrontMiddleBackQueue {
    boolean evenSize;
    private Node leftBorder, rightBorder, middleNode;

    public FrontMiddleBackQueue() {
        leftBorder = new Node();
        rightBorder = new Node();
        leftBorder.right = rightBorder;
        rightBorder.left = leftBorder;
        evenSize = true;
    }

    public void pushFront(int val) {
        Node node = new Node(leftBorder, leftBorder.right, val);
        if (leftBorder.right == rightBorder) middleNode = node;
        leftBorder.right.left = node;
        leftBorder.right = node;
        evenSize = !evenSize;
        if (evenSize) middleNode = middleNode.left;
    }

    public void pushMiddle(int val) {
        if (leftBorder.right == rightBorder) {
            Node node = new Node(leftBorder, rightBorder, val);
            evenSize = false;
            leftBorder.right = node;
            rightBorder.left = node;
            middleNode = node;
        } else {
            Node node;
            if (evenSize) {
                node = new Node(middleNode, middleNode.right, val);
                middleNode.right.left = node;
                middleNode.right = node;
            } else {
                node = new Node(middleNode.left, middleNode, val);
                middleNode.left.right = node;
                middleNode.left = node;
            }
            middleNode = node;
            evenSize = !evenSize;
        }
    }

    public void pushBack(int val) {
        Node node = new Node(rightBorder.left, rightBorder, val);
        if (leftBorder.right == rightBorder) middleNode = leftBorder;
        rightBorder.left.right = node;
        rightBorder.left = node;
        evenSize = !evenSize;
        if (!evenSize) middleNode = middleNode.right;
    }

    public int popFront() {
        Node node = leftBorder.right;
        if (node == rightBorder) return -1;
        node.left.right = node.right;
        node.right.left = node.left;
        evenSize = !evenSize;
        if (!evenSize) middleNode = middleNode.right;
        return node.val;
    }

    public int popMiddle() {
        if (leftBorder.right == rightBorder) return -1;
        Node node = middleNode;
        node.left.right = node.right;
        node.right.left = node.left;
        evenSize = !evenSize;
        if (evenSize) middleNode = middleNode.left;
        else middleNode = middleNode.right;
        return node.val;
    }

    public int popBack() {
        Node node = rightBorder.left;
        if (node == leftBorder) return -1;
        node.left.right = node.right;
        node.right.left = node.left;
        evenSize = !evenSize;
        if (evenSize) middleNode = middleNode.left;
        return node.val;
    }

    private static class Node {
        Node left, right;
        int val;

        Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        Node() {
        }
    }
}
