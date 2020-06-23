package sbercraft;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {
    public static int getTotalTime(List<Integer> heroes, int n) {
        if (heroes.size() <= n) return heroes.stream().max(Comparator.naturalOrder()).get();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(heroes.get(i));
        }
        for (int i = n; i < heroes.size(); i++) {
            pq.offer(pq.poll() + heroes.get(i));
        }
        int ans = 0;
        while (!pq.isEmpty()) ans = pq.poll();
        return ans;
    }
}
