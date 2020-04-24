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
            removeFromCurrent(node);
            insertToEnd(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        DoubleLinkedList node = map.get(key);
        if (node != null) {
            removeFromCurrent(node);
            insertToEnd(node);
            node.val = value;
        } else {
            node = new DoubleLinkedList(key, value);
            insertToEnd(node);
            map.put(key, node);
            if (map.size() > maxSize) {
                DoubleLinkedList toDelete = leftBorder.right;
                map.remove(toDelete.key);
                removeFromCurrent(toDelete);
            }
        }
    }

    private void removeFromCurrent(DoubleLinkedList node) {
        node.left.right = node.right;
        node.right.left = node.left;
    }

    private void insertToEnd(DoubleLinkedList node) {
        node.left = rightBorder.left;
        node.right = rightBorder;
        rightBorder.left.right = node;
        rightBorder.left = node;
    }

    private static class DoubleLinkedList {
        int key;
        int val;
        DoubleLinkedList left;
        DoubleLinkedList right;

        public DoubleLinkedList(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public DoubleLinkedList() {
        }
    }
}
