package leetcode.leetcode13xx.leetcode1306;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new ArrayDeque<>(n);
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int a = arr[poll];
            arr[poll] = -1;
            if (a == -1) continue;
            if (a == 0) return true;
            if (poll - a >= 0) queue.offer(poll - a);
            if (poll + a < n) queue.offer(poll + a);
        }
        return false;
    }
}
