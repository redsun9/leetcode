package leetcode.leetcode5xx.leetcode502;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> available = new PriorityQueue<>(Comparator.comparingInt(x -> x.capital));
        PriorityQueue<Project> profitable = new PriorityQueue<>(Comparator.comparingInt(x -> -x.profit));
        int n = profits.length;
        for (int i = 0; i < n; i++) available.offer(new Project(profits[i], capital[i]));
        while (k-- > 0) {
            while (!available.isEmpty() && available.peek().capital <= w) profitable.offer(available.poll());
            if (profitable.isEmpty()) break;
            w += profitable.poll().profit;
        }
        return w;
    }

    private static class Project {
        int profit, capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}
