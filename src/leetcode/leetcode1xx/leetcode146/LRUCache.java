package leetcode.leetcode1xx.leetcode146;

import java.util.HashMap;

public class LRUCache {
    private final HashMap<Integer, DoubleLinkedList> map;
    private final int maxSize;
    private final DoubleLinkedList leftBorder;
    private final DoubleLinkedList rightBorder;

    public LRUCache(int capacity) {
        maxSize = capacity;
        map = new HashMap<>((int) (capacity * 1.5));
        leftBorder = new DoubleLinkedList();
        rightBorder = new DoubleLinkedList();
        leftBorder.right = rightBorder;
        rightBorder.left = leftBorder;
    }

    public int get(int key) {
        DoubleLinkedList node = map.get(key);
        if (node == null) return -1;
        else {
            node.left.right = node.right;
            node.right.left = node.left;
            node.left = rightBorder.left;
            node.right = rightBorder;
            rightBorder.left.right = node;
            rightBorder.left = node;
            return node.val;
        }
    }

    public void put(int key, int value) {
        DoubleLinkedList node = map.get(key);
        if (node != null) {
            node.left.right = node.right;
            node.right.left = node.left;
            node.left = rightBorder.left;
            node.right = rightBorder;
            rightBorder.left.right = node;
            rightBorder.left = node;
            node.val = value;
        } else {
            DoubleLinkedList newNode = new DoubleLinkedList(key, value, rightBorder.left, rightBorder);
            rightBorder.left.right = newNode;
            rightBorder.left = newNode;
            map.put(key, newNode);
            if (map.size() > maxSize) {
                DoubleLinkedList toDelete = leftBorder.right;
                map.remove(toDelete.key);
                leftBorder.right = toDelete.right;
                toDelete.right.left = leftBorder;
            }
        }
    }

    private static class DoubleLinkedList {
        int key;
        int val;
        DoubleLinkedList left;
        DoubleLinkedList right;

        public DoubleLinkedList(int key, int val, DoubleLinkedList left, DoubleLinkedList right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public DoubleLinkedList() {
        }
    }
}
