package leetcode.leetcode8xx.leetcode895;

import java.util.HashMap;

public class FreqStack {
    private final HashMap<Integer, DoubleLinkedList> freqToPos;
    private final HashMap<Integer, Integer> intToFreq;
    private final DoubleLinkedList leftBorder, rightBorder;

    public FreqStack() {
        freqToPos = new HashMap<>();
        intToFreq = new HashMap<>();
        leftBorder = new DoubleLinkedList(0, 0);
        rightBorder = new DoubleLinkedList(0, Integer.MAX_VALUE);
        freqToPos.put(0, leftBorder);
        leftBorder.right = rightBorder;
        rightBorder.left = leftBorder;
    }

    public void push(int x) {
        int curFreq = intToFreq.getOrDefault(x, 0) + 1;
        DoubleLinkedList newNode = new DoubleLinkedList(x, curFreq);
        DoubleLinkedList prev = freqToPos.getOrDefault(curFreq, rightBorder.left);
        newNode.right = prev.right;
        newNode.left = prev;
        prev.right.left = newNode;
        prev.right = newNode;
        freqToPos.put(curFreq, newNode);
        intToFreq.put(x, curFreq);
    }

    public int pop() {
        DoubleLinkedList node = rightBorder.left;
        if (node.freq == node.left.freq) {
            freqToPos.put(node.freq, node.left);
        } else {
            freqToPos.remove(node.freq);
        }
        if (node.freq > 1) {
            intToFreq.put(node.val, node.freq - 1);
        } else {
            intToFreq.remove(node.val);
        }
        node.left.right = node.right;
        node.right.left = node.left;
        return node.val;
    }


    private static class DoubleLinkedList {
        int val, freq;
        DoubleLinkedList left, right;

        public DoubleLinkedList(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
}
