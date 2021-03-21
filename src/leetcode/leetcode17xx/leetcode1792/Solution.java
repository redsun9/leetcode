package leetcode.leetcode17xx.leetcode1792;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(x -> x.d));
        double sum = 0;
        for (int[] cls : classes) {
            if (cls[0] == cls[1]) sum += 1;
            else pq.offer(new Node(cls[1] - cls[0], cls[1]));
        }
        if (pq.isEmpty()) return 1;
        while (extraStudents-- != 0) {
            Node node = pq.poll();
            pq.offer(new Node(node.f, node.t + 1));
        }
        for (Node node : pq) {
            sum += (node.t - node.f) / (double) node.t;
        }
        return sum / n;
    }

    private static class Node {
        int f, t;
        double d;

        Node(int f, int t) {
            this.f = f;
            this.t = t;
            this.d = -((double) f) / t / (t + 1);
        }
    }
}
