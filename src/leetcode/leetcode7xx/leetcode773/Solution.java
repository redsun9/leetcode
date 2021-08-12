package leetcode.leetcode7xx.leetcode773;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final int[] moves = {1, -1, 3, -3};

    public int slidingPuzzle(int[][] board) {
        int[] pow = new int[6];
        for (int i = 0, val = 1; i < 6; i++, val *= 6) pow[i] = val;

        int key = 0, end = 0, z = 0;
        for (int i = 0; i < 6; i++) key += board[i / 3][i % 3] * pow[i];
        for (int i = 1; i <= 5; i++) end += i * pow[i - 1];
        if (key == end) return 0;

        int[] node = new int[9]; // 0-5 digits, 6 - index of 0, 7 - nextVal, 8 - key
        for (int i = 0; i < 6; i++) {
            node[i] = board[i / 3][i % 3];
            if (node[i] == 0) z = i;
        }
        node[6] = z;
        node[8] = key;

        HashSet<Integer> set = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        set.add(key);
        queue.add(node);

        int nextKey, nextVal, nextZ;
        while (!queue.isEmpty()) {
            node = queue.poll();
            z = node[6];
            nextVal = node[7] + 1;
            key = node[8];
            for (int move : moves) {
                nextZ = z + move;
                if (nextZ >= 0 && nextZ <= 5 && Math.abs(z % 3 - nextZ % 3) <= 1 && Math.abs(z / 3 - nextZ / 3) <= 1) {
                    nextKey = key - node[nextZ] * pow[nextZ] + node[nextZ] * pow[z];
                    if (nextKey == end) return nextVal;
                    if (set.add(nextKey)) {
                        int[] newNode = Arrays.copyOf(node, 9);
                        newNode[z] = node[nextZ];
                        newNode[6] = nextZ;
                        newNode[7] = nextVal;
                        newNode[8] = nextKey;
                        queue.add(newNode);
                    }
                }
            }
        }
        return -1;
    }
}
