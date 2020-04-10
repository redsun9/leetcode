package leetcode.leetcode10xx.leetcode1094;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int currentNumber = 0;
        Arrays.sort(trips, Comparator.comparingInt(t -> t[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t[2]));
        for (int[] trip : trips) {
            int startPos = trip[1];
            while (!queue.isEmpty() && queue.peek()[2] <= startPos) {
                int[] poll = queue.poll();
                currentNumber -= poll[0];
            }
            currentNumber += trip[0];
            if (currentNumber > capacity) return false;
            queue.add(trip);
        }
        return true;
    }
}
