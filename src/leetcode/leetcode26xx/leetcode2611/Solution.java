package leetcode.leetcode26xx.leetcode2611;

import java.util.PriorityQueue;

@SuppressWarnings("DataFlowIssue")
public class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int total = 0;
        for (int i : reward2) total += i;
        PriorityQueue<Integer> priority = new PriorityQueue<>();
        for (int i = 0; i < n; i++) priority.add(reward2[i] - reward1[i]);
        for (int i = 0; i < k; i++) total -= priority.poll();
        return total;
    }
}
