package leetcode.leetcode432;

import java.util.HashMap;

public class AllOne {
    private final HashMap<String, DoubleLinkedList> map;
    private final DoubleLinkedList leftBorder;
    private final DoubleLinkedList rightBorder;
    private final HashMap<Integer, DoubleLinkedList> lastUsedWithFrequency;

    public AllOne() {
        map = new HashMap<>();
        lastUsedWithFrequency = new HashMap<>();
        leftBorder = new DoubleLinkedList();
        rightBorder = new DoubleLinkedList();
        leftBorder.right = rightBorder;
        rightBorder.left = leftBorder;
        leftBorder.val = 0;
        rightBorder.val = Integer.MAX_VALUE;
        leftBorder.key = "";
        rightBorder.key = "";
        lastUsedWithFrequency.put(0, leftBorder);
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        DoubleLinkedList node = map.get(key);
        if (node == null) {
            node = new DoubleLinkedList(key, leftBorder, leftBorder.right);
            lastUsedWithFrequency.putIfAbsent(1, node);
            leftBorder.right.left = node;
            leftBorder.right = node;
            map.put(key, node);
        } else {
            if (node.right.val > node.val) {
                //можно не перемещать
                lastUsedWithFrequency.remove(node.val);
                //обновить мапу с адресами самых левых
                if (node.left.val == node.val) {
                    lastUsedWithFrequency.put(node.left.val, node.left);
                }
                node.val++;
                if (node.right.val != node.val) {
                    lastUsedWithFrequency.put(node.val, node);
                }
            } else {
                node.left.right = node.right;
                node.right.left = node.left;
                node.val++;
                DoubleLinkedList toInsert =
                        lastUsedWithFrequency.containsKey(node.val)
                                ? lastUsedWithFrequency.get(node.val)
                                : lastUsedWithFrequency.get(node.val - 1);
                toInsert.right.left = node;
                node.right = toInsert.right;
                toInsert.right = node;
                node.left = toInsert;
                lastUsedWithFrequency.put(node.val, node);
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        DoubleLinkedList node = map.get(key);
        if (node != null) {
            if (node.left.val < node.val) {
                //можно не двигать
                if (node.right.val > node.val) {
                    lastUsedWithFrequency.remove(node.val);
                }
                node.val--;
                if (node.val == 0) {
                    map.remove(key);
                    node.left.right = node.right;
                    node.right.left = node.left;
                } else {
                    lastUsedWithFrequency.put(node.val, node);
                }
            } else {
                node.left.right = node.right;
                node.right.left = node.left;
                node.val--;
                if (node.val == 0) {
                    map.remove(key);
                } else {
                    DoubleLinkedList toInsert =
                            lastUsedWithFrequency.containsKey(node.val)
                                    ? lastUsedWithFrequency.get(node.val)
                                    : lastUsedWithFrequency.get(node.val - 1);
                    toInsert.right.left = node;
                    node.right = toInsert.right;
                    toInsert.right = node;
                    node.left = toInsert;
                    lastUsedWithFrequency.put(node.val, node);
                }
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return rightBorder.left.key;
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return leftBorder.right.key;
    }

    private static class DoubleLinkedList {
        String key;
        int val = 1;
        DoubleLinkedList left;
        DoubleLinkedList right;

        public DoubleLinkedList(String key, DoubleLinkedList left, DoubleLinkedList right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public DoubleLinkedList() {
        }
    }
}
