package leetcode.leetcode11xx.leetcode1167;

import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int MinimumCost(List<Integer> sticks) {
        int n = sticks.size();
        if (n <= 1) return 0;
        if (n == 2) return sticks.get(0) + sticks.get(1);

        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(sticks);
        for (int i = 1; i < n; i++) {
            int c = pq.poll() + pq.poll();
            ans += c;
            pq.offer(c);
        }
        return ans;
    }
}
