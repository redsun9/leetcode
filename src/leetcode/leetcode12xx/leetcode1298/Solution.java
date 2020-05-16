package leetcode.leetcode12xx.leetcode1298;

import java.util.ArrayDeque;

public class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans = 0;
        int n = status.length;
        boolean[] visited = new boolean[n];
        boolean[] meetBox = new boolean[n];
        boolean[] haveKey = new boolean[n];
        ArrayDeque<Integer> queue = new ArrayDeque<>(n);
        for (int box : initialBoxes) {
            queue.add(box);
            haveKey[box] = true;
            meetBox[box] = true;
        }
        while (!queue.isEmpty()) {
            Integer box = queue.pop();
            if (visited[box]) continue;
            if (meetBox[box] && (status[box] == 1 || haveKey[box])) {
                visited[box] = true;
                ans += candies[box];
                for (int k : keys[box]) {
                    haveKey[k] = true;
                    if (!visited[k]) queue.add(k);
                }
                for (int containedBox : containedBoxes[box]) {
                    queue.add(containedBox);
                    meetBox[containedBox] = true;
                }
            }
        }
        return ans;
    }
}
