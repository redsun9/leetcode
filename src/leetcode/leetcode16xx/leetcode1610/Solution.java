package leetcode.leetcode16xx.leetcode1610;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    private double eps = 1e-18;

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int n = points.size();
        if (n <= 1) return n;
        int pointsAtTheYourLocation = 0;
        double a = eps + angle * Math.PI / 180;
        int x = location.get(0);
        int y = location.get(1);
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (List<Integer> p : points) {
            if (p.get(0) == x && p.get(1) == y) pointsAtTheYourLocation++;
            else {
                double b = Math.atan2(p.get(0) - x, p.get(1) - y);
                pq.add(b);
                pq.add(b + 2 * Math.PI);
            }
        }
        int max = 0;
        Queue<Double> queue = new LinkedList<>();
        while (!pq.isEmpty()) {
            Double poll = pq.poll();
            queue.add(poll + a);
            while (!queue.isEmpty() && queue.peek() < poll) queue.poll();
            max = Math.max(max, queue.size());
        }
        return max + pointsAtTheYourLocation;
    }
}
