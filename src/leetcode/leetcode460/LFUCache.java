package leetcode.leetcode460;

import java.util.HashMap;

public class LFUCache {
    private final HashMap<Integer, DoubleLinkedList> map;
    private final int maxSize;
    private final DoubleLinkedList leftBorder;
    private final HashMap<Integer, DoubleLinkedList> lastUsedWithFrequency;

    public LFUCache(int capacity) {
        maxSize = capacity;
        map = new HashMap<>((int) (capacity * 1.5));
        lastUsedWithFrequency = new HashMap<>((int) (capacity * 1.5));
        leftBorder = new DoubleLinkedList();
        DoubleLinkedList rightBorder = new DoubleLinkedList();
        leftBorder.right = rightBorder;
        leftBorder.usages = 0;
        rightBorder.left = leftBorder;
        rightBorder.usages = Integer.MAX_VALUE;
    }

    public int get(int key) {
        DoubleLinkedList node = map.get(key);
        if (node == null) return -1;
        else {
            //это самая правая вершина с таким количеством использования
            if (node.usages < node.right.usages) {
                // удаляем и обновляем значение на вершину слева, если у нее совпадает количество использований
                lastUsedWithFrequency.remove(node.usages);
                if (node.left.usages == node.usages) {
                    lastUsedWithFrequency.put(node.usages, node.left);
                }
            }
            //удаляем ее из списка если надо
            node.usages++;
            if (node.usages >= node.right.usages) {
                //надо двигать куда-то вправо
                node.left.right = node.right;
                node.right.left = node.left;
                //если есть ноды с использованием, то вставляем вперед них
                DoubleLinkedList toInsert =
                        lastUsedWithFrequency.containsKey(node.usages) ?
                                lastUsedWithFrequency.get(node.usages)
                                : lastUsedWithFrequency.get(node.usages - 1);
                node.right = toInsert.right;
                node.left = toInsert;
                toInsert.right.left = node;
                toInsert.right = node;
            }
            lastUsedWithFrequency.put(node.usages, node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if (maxSize == 0) return;
        ;
        DoubleLinkedList node = map.get(key);
        if (node != null) {
            //это самая правая вершина с таким количеством использования
            if (node.usages < node.right.usages) {
                // удаляем и обновляем значение на вершину слева, если у нее совпадает количество использований
                lastUsedWithFrequency.remove(node.usages);
                if (node.left.usages == node.usages) {
                    lastUsedWithFrequency.put(node.usages, node.left);
                }
            }
            //удаляем ее из списка если надо
            node.usages++;
            if (node.usages >= node.right.usages) {
                //надо двигать куда-то вправо
                node.left.right = node.right;
                node.right.left = node.left;
                //если есть ноды с использованием, то вставляем вперед них
                DoubleLinkedList toInsert =
                        lastUsedWithFrequency.containsKey(node.usages) ?
                                lastUsedWithFrequency.get(node.usages)
                                : lastUsedWithFrequency.get(node.usages - 1);
                node.right = toInsert.right;
                node.left = toInsert;
                toInsert.right.left = node;
                toInsert.right = node;
            }
            lastUsedWithFrequency.put(node.usages, node);
            node.val = value;
        } else {
            if (map.size() == maxSize) {
                DoubleLinkedList toDelete = leftBorder.right;
                if (toDelete.usages < toDelete.right.usages) {
                    lastUsedWithFrequency.remove(toDelete.usages);
                }
                map.remove(toDelete.key);
                leftBorder.right = toDelete.right;
                toDelete.right.left = leftBorder;
            }

            DoubleLinkedList toInsert = lastUsedWithFrequency.getOrDefault(1, leftBorder);
            DoubleLinkedList newNode = new DoubleLinkedList(key, value, toInsert, toInsert.right);
            toInsert.right.left = newNode;
            toInsert.right = newNode;
            map.put(key, newNode);
            lastUsedWithFrequency.put(1, newNode);
        }
    }

    private static class DoubleLinkedList {
        int key;
        int val;
        int usages;
        DoubleLinkedList left;
        DoubleLinkedList right;

        public DoubleLinkedList(int key, int val, DoubleLinkedList left, DoubleLinkedList right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
            this.usages = 1;
        }

        public DoubleLinkedList() {
        }
    }
}
