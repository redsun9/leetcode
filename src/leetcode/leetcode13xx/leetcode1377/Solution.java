package leetcode.leetcode13xx.leetcode1377;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (n == 1) return 1.0;
        if (n == 2) return target != 1 ? 1.0 : 0;
        if (target == 1) return 0;
        target--;
        LinkedList<Integer>[] neighbours = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            neighbours[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            neighbours[edge[0] - 1].add(edge[1] - 1);
            neighbours[edge[1] - 1].add(edge[0] - 1);
        }
        boolean[] v = new boolean[n];
        int[] s = new int[n];
        s[0] = 0;
        int[] m = new int[n];
        m[0] = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            v[poll] = true;
            if (poll == target) {
                if (s[poll] == t || neighbours[poll].size() == 1) return 1.0d / m[poll];
                else return 0;
            } else if (s[poll] < t) {
                int newM = poll == 0 ? neighbours[0].size() : m[poll] * (neighbours[poll].size() - 1);
                int newS = s[poll] + 1;
                for (Integer neighbour : neighbours[poll]) {
                    if (!v[neighbour]) {
                        s[neighbour] = newS;
                        m[neighbour] = newM;
                        queue.add(neighbour);
                    }
                }
            }
        }
        return 0;
    }
}
