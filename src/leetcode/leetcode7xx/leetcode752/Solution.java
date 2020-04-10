package leetcode.leetcode7xx.leetcode752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<Integer> forbidden = new HashSet<>();
        for (String deadend : deadends) {
            forbidden.add(Integer.parseInt(deadend));
        }
        if (forbidden.contains(0)) return -1;
        int end = Integer.parseInt(target);
        if (end == 0) return 0;
        int[] seen = new int[10000];
        seen[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (end == poll) return seen[end] - 1;
            for (int i = 0, tmp1 = 1, tmp2 = 10; i < 4; i++, tmp1 *= 10, tmp2 *= 10) {
                int a = poll % tmp2;
                int top = poll - a + (a + tmp1) % tmp2;
                if (!forbidden.contains(top) && seen[top] == 0) {
                    seen[top] = seen[poll] + 1;
                    queue.add(top);
                }
                int bot = poll - a + (a - tmp1 + tmp2) % tmp2;
                if (!forbidden.contains(bot) && seen[bot] == 0) {
                    seen[bot] = seen[poll] + 1;
                    queue.add(bot);
                }
            }
        }
        return -1;
    }
}
