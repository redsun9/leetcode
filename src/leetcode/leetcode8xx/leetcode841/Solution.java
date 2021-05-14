package leetcode.leetcode8xx.leetcode841;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] keys = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        keys[0] = true;
        n--;
        while (n != 0 && !queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer room : rooms.get(poll)) {
                if (!keys[room]) {
                    queue.offer(room);
                    keys[room] = true;
                    n--;
                }
            }
        }
        return n == 0;
    }
}
