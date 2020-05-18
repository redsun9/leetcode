package leetcode.leetcode13xx.leetcode1361;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] tmp = new boolean[n];
        for (int i : leftChild) if (i >= 0) tmp[i] = true;
        for (int i : rightChild) if (i >= 0) tmp[i] = true;
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!tmp[i]) {
                if (root == -1) root = i;
                else return false;
            }
        }
        if (root == -1) return false;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        Arrays.fill(tmp, false);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (tmp[poll]) return false;
            tmp[poll] = true;
            n--;
            if (leftChild[poll] != -1) queue.add(leftChild[poll]);
            if (rightChild[poll] != -1) queue.add(rightChild[poll]);
        }
        return n == 0;
    }
}
