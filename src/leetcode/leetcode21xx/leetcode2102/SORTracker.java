package leetcode.leetcode21xx.leetcode2102;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class SORTracker {
    private final TreeSet<Node> set;
    private Node currentToReturn;
    private static final Comparator<Node> comparator = (a, b) -> {
        if (Objects.equals(a.name, b.name)) return 0;
        if (a.name == null) return -1;
        if (b.name == null) return 1;
        if (a.score == b.score) return CharSequence.compare(b.name, a.name);
        return Integer.compare(a.score, b.score);
    };


    public SORTracker() {
        Node leftBorder = new Node(null, Integer.MIN_VALUE);
        Node rightBorder = new Node(null, Integer.MAX_VALUE);
        leftBorder.right = rightBorder;
        rightBorder.left = leftBorder;
        this.currentToReturn = leftBorder;
        this.set = new TreeSet<>(comparator);
        this.set.add(leftBorder);
    }

    @SuppressWarnings("ConstantConditions")
    public void add(String name, int score) {
        Node node = new Node(name, score);
        Node floor = set.floor(node);
        node.right = floor.right;
        node.left = floor;
        floor.right.left = node;
        floor.right = node;
        set.add(node);
        if (comparator.compare(currentToReturn, node) < 0) currentToReturn = currentToReturn.right;
    }

    public String get() {
        String ans = currentToReturn.name;
        currentToReturn = currentToReturn.left;
        return ans;
    }


    private static class Node {
        final String name;
        final int score;
        Node left, right;

        private Node(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
