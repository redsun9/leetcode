package leetcode.leetcode8xx.leetcode851;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Set<Integer>[] inc = new HashSet[n];
        Set<Integer>[] out = new HashSet[n];
        int[] children = new int[n];
        for (int i = 0; i < n; i++) {
            inc[i] = new HashSet<>();
            out[i] = new HashSet<>();
        }
        for (int[] edge : richer) {
            out[edge[0]].add(edge[1]);
            inc[edge[1]].add(edge[0]);
            children[edge[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inc[i].isEmpty()) queue.add(i);
        }

        int[] ans = new int[n];
        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            int tmp = i;
            for (Integer child : inc[i]) {
                if (quiet[tmp] > quiet[ans[child]]) tmp = ans[child];
            }
            ans[i] = tmp;
            for (Integer father : out[i]) {
                if (--children[father] == 0) queue.add(father);
            }
        }
        return ans;
    }
}
