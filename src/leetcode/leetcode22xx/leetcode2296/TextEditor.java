package leetcode.leetcode22xx.leetcode2296;

public class TextEditor {
    private final Node current = new Node();

    public void addText(String text) {
        int n = text.length();
        if (n == 0) return;
        Node head = new Node(text.charAt(0));
        Node tail = head;
        for (int i = 1; i < n; i++) {
            Node node = new Node(text.charAt(i));
            node.left = tail;
            tail.right = node;
            tail = node;
        }
        tail.right = current;
        head.left = current.left;
        if (current.left != null) current.left.right = head;
        current.left = tail;
    }

    public int deleteText(int k) {
        int ans = 0;
        while (k-- > 0 && current.left != null) {
            current.left = current.left.left;
            if (current.left != null) current.left.right = current;
            ans++;
        }
        return ans;
    }

    public String cursorLeft(int k) {
        while (k-- > 0 && current.left != null) {
            if (current.right != null) current.right.left = current.left;
            current.left.right = current.right;
            current.right = current.left;
            current.left = current.right.left;
            if (current.left != null) current.left.right = current;
            current.right.left = current;
        }
        return getString();
    }

    public String cursorRight(int k) {
        while (k-- > 0 && current.right != null) {
            if (current.left != null) current.left.right = current.right;
            current.right.left = current.left;
            current.left = current.right;
            current.right = current.left.right;
            if (current.right != null) current.right.left = current;
            current.left.right = current;
        }
        return getString();
    }

    private String getString() {
        char[] ans = new char[10];
        int n = 10;
        Node node = current;
        while (node.left != null && n != 0) {
            node = node.left;
            ans[--n] = node.c;
        }
        return new String(ans, n, 10 - n);
    }

    private static class Node {
        private Character c;
        private Node left, right;

        Node(char c) {
            this.c = c;
            this.left = null;
            this.right = null;
        }

        Node() {
        }
    }
}
