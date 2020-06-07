package leetcode.leetcode14xx.leetcode1472;

public class BrowserHistory {
    private Node currentNode;

    public BrowserHistory(String homepage) {
        currentNode = new Node(homepage);
    }

    public void visit(String url) {
        currentNode.next = new Node(url);
        currentNode.next.prev = currentNode;
        currentNode = currentNode.next;
    }

    public String back(int steps) {
        while (steps > 0 && currentNode.prev != null) {
            currentNode = currentNode.prev;
            steps--;
        }
        return currentNode.val;
    }

    public String forward(int steps) {
        while (steps > 0 && currentNode.next != null) {
            currentNode = currentNode.next;
            steps--;
        }
        return currentNode.val;
    }


    private static class Node {
        String val;
        Node prev, next;

        public Node(String val) {
            this.val = val;
        }
    }
}
