package leetcode.leetcode16xx.leetcode1600;

import java.util.*;

public class ThroneInheritance {
    private final Node root;
    private final Map<String, Node> map = new HashMap<>();
    private int currentAlive;
    private int maxDepth;

    public ThroneInheritance(String kingName) {
        root = new Node(kingName, 1);
        map.put(kingName, root);
        currentAlive = 1;
        maxDepth = 1;
    }

    public void birth(String parentName, String childName) {
        Node parent = map.get(parentName);
        Node child = new Node(childName, parent.depth + 1);
        parent.children.addFirst(child);
        maxDepth = Math.max(maxDepth, child.depth);
        map.put(childName, child);
        currentAlive++;
    }

    public void death(String name) {
        map.get(name).dead = true;
        currentAlive--;
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>(currentAlive);
        ArrayDeque<Node> stack = new ArrayDeque<>(maxDepth);
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            if (!node.dead) ans.add(node.name);
            stack.addAll(node.children);
        }
        return ans;
    }


    private final static class Node {
        private final String name;
        private final int depth;
        private final LinkedList<Node> children = new LinkedList<>();
        private boolean dead;

        public Node(String name, int depth) {
            this.name = name;
            this.depth = depth;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return name.equals(node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }


    }
}
